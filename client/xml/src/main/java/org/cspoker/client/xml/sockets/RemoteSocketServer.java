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
package org.cspoker.client.xml.sockets;

import java.rmi.RemoteException;

import javax.security.auth.login.LoginException;

import org.cspoker.client.xml.common.context.XmlRemoteServerContext;
import org.cspoker.common.RemoteCSPokerServer;
import org.cspoker.common.api.shared.context.RemoteServerContext;

public class RemoteSocketServer implements RemoteCSPokerServer {

	private final String server;
	private final int port;

	public RemoteSocketServer(String server, int port) {
		this.server = server;
		this.port = port;
	}

	public String toString() {
		return "socket://" + server + ":" + port;
	}

	public RemoteServerContext login(String username, String password)
			throws RemoteException, LoginException {
		return new XmlRemoteServerContext(new XmlSocketsChannel(server, port, username,password));
	}

}
