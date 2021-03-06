/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.server.xml.sockets.runnables;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

import org.apache.log4j.Logger;
import org.cspoker.common.CSPokerServer;
import org.cspoker.common.util.threading.Prioritizable;
import org.cspoker.server.xml.sockets.ClientContext;

public class WaitForIO
implements Runnable, Prioritizable {

	private final static Logger logger = Logger.getLogger(WaitForIO.class);

	private final Executor executor;
	private final Selector selector;
	private ServerSocketChannel server;

	public final static int bufferSize = 1024 * 4;
	private final ByteBuffer buffer;
	private final ByteBuffer filteredBuffer;

	private final Charset charset;
	private final CharsetDecoder decoder;

	private CSPokerServer cspokerServer;

	public WaitForIO(Executor executor, Selector selector, ServerSocketChannel server, CSPokerServer cspokerServer) {
		this.executor = executor;
		this.selector = selector;
		this.server = server;
		this.cspokerServer = cspokerServer;

		buffer = ByteBuffer.allocateDirect(bufferSize);
		filteredBuffer = ByteBuffer.allocateDirect(bufferSize);

		charset = Charset.forName("UTF-8");
		decoder = charset.newDecoder();
	}

	public void run() {
		logger.trace("Starting to wait for work.");
		waitForWork();
		logger.trace("Done waiting for work.");
		executor.execute(this);
	}

	public int getPriority() {
		return -1;
	}

	private void waitForWork() {
		// Waiting for events
		try {
			selector.select();
			// Get keys
			Set<SelectionKey> keys = selector.selectedKeys();
			Iterator<SelectionKey> i = keys.iterator();

			logger.trace("Selecting keys");
			// For each key...
			while (i.hasNext()) {
				try {
					SelectionKey key = i.next();

					logger.trace("Selected new key.");
					if (key.isReadable()) {
						logger.trace("Reading from socket");
						readSocket(key);
					}
					if (key.isWritable()) {
						logger.trace("Writing data to socket");
						getContext(key, (SocketChannel) key.channel()).writeBufferToClient();
					}
					if (key.isAcceptable()) {
						SocketChannel client = acceptConnection();
						logger.trace("Accepted new connection from "+client.socket().getRemoteSocketAddress());
					}
					logger.trace("Selected key is processed.");
					i.remove(); // remove the key
				} catch (CancelledKeyException e) {
					logger.debug("Cancelled selected key, ignoring.");
				}
			}
		} catch (IOException e) {
			// no op
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

	private void readSocket(SelectionKey key)
	throws IOException {
		SocketChannel client = (SocketChannel) key.channel();
		try {
			// Clear the buffer and read bytes from socket
			buffer.clear();
			int numBytesRead = client.read(buffer);

			if (numBytesRead == -1) {
				// No more bytes can be read from the channel
				logger.debug("channel has reached end-of-stream");
				ClientContext context = getContext(key, client);
				context.closeConnection();
			} else {
				logger.trace("Reading " + numBytesRead + " bytes from socket");
				// To read the bytes, flip the buffer
				buffer.flip();
				ClientContext context = getContext(key, client);
				StringBuilder stringBuilder = context.getBuffer();

				while (buffer.hasRemaining()) {
					boolean hasEnded = filterUntilEndNode();

					CharBuffer decoded = decoder.decode(filteredBuffer);
					logger.trace("Reading: \n" + decoded);
					stringBuilder.append(decoded);
					if (hasEnded) {
						endNode(stringBuilder, context);
					}
				}
			}
		} catch (IOException e) {
			logger.debug("Exception reading from socket, closing socket: "+e.getMessage());
			ClientContext context = getContext(key, client);
			context.closeConnection();
			// Rethrow exception as declared
			throw (e);
		}

	}

	private ClientContext getContext(SelectionKey key, SocketChannel client) {
		ClientContext context = (ClientContext) (key.attachment());
		if (context == null) {
			context = new ClientContext(client, selector, cspokerServer);
			key.attach(context);
		}
		return context;

	}

	private boolean filterUntilEndNode() {
		filteredBuffer.clear();
		while (buffer.hasRemaining()) {
			byte b = buffer.get();
			if (b == 0x00) {
				filteredBuffer.flip();
				return true;
			} else {
				filteredBuffer.put(b);
			}

		}
		filteredBuffer.flip();
		return false;
	}

	private SocketChannel acceptConnection()
	throws IOException {
		// get client socket channel
		SocketChannel client = server.accept();
		// Non Blocking I/O
		client.configureBlocking(false);
		// recording to the selector (reading)
		client.register(selector, SelectionKey.OP_READ);
		return client;
	}

	private void endNode(StringBuilder stringBuilder, ClientContext context) {
		String xml = stringBuilder.toString();
		executor.execute(new ProcessXML(xml, context, cspokerServer));
		stringBuilder.setLength(0);
	}

	@Override
	public String toString() {
		return "WaitForIO";
	}
}
