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
package org.cspoker.common.api.chat.context;

import java.rmi.RemoteException;

import org.cspoker.common.api.chat.listener.ChatListener;
import org.cspoker.common.api.chat.listener.ForwardingChatListener;


public class ForwardingRemoteChatContext implements RemoteChatContext{

	private RemoteChatContext chatContext;
	private ForwardingChatListener forwardingChatListener;

	public ForwardingRemoteChatContext(RemoteChatContext chatContext) throws RemoteException {
		this.chatContext  = chatContext;
		this.forwardingChatListener = new ForwardingChatListener();
		chatContext.subscribe(wrapListener(forwardingChatListener));
	}
	
	public ChatListener wrapListener(ChatListener listener) throws RemoteException{
		return listener;
	}

	public void sendServerMessage(String message) throws RemoteException {
		chatContext.sendServerMessage(message);
	}

	public void sendTableMessage(long tableId, String message) throws RemoteException {
		chatContext.sendTableMessage(tableId, message);
	}

	public void subscribe(ChatListener chatListener)  throws RemoteException {
		forwardingChatListener.subscribe(chatListener);
	}

	public void unSubscribe(ChatListener chatListener)  throws RemoteException {
		forwardingChatListener.unSubscribe(chatListener);
	}
	
}
