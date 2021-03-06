package policyserver;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.rmi.RemoteException;

public class SendPolicyRequest{
	
	public static void main(String[] args) throws IOException {
		new SendPolicyRequest("localhost",8081);
	}
	
	private final Socket socket;
	private final Writer socketWriter;

	private final CharsetDecoder decoder;

	public SendPolicyRequest(String server, int port) throws IOException {
		Charset charset = Charset.forName("UTF-8");
		decoder = charset.newDecoder();
		try {
			socket = new Socket(server, port);
			socketWriter = new OutputStreamWriter(socket.getOutputStream());
		} catch (UnknownHostException exception) {
			throw new RemoteException("Exception opening socket.", exception);
		} catch (IOException exception) {
			throw new RemoteException("Exception opening socket.", exception);
		}
		socketWriter.append("<policy-file-request/>\u0000");
		socketWriter.flush();
		StringBuffer sb = new StringBuffer();
		ByteBuffer singleByteBuffer = ByteBuffer.allocateDirect(1);
		while (true) {
			int b = socket.getInputStream().read();
			if (b < 0) {
				System.out.println("Connection lost");
				return;
			}
			if (b == 0) {
				System.out.println(sb);
				sb.setLength(0);
				System.out.println("Delimiter found");
			} else {
				singleByteBuffer.put((byte) b);
				singleByteBuffer.flip();
				CharBuffer decoded = decoder.decode(singleByteBuffer);
				sb.append(decoded);
				singleByteBuffer.clear();
			}
		}
	}

}
