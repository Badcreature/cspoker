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
package org.cspoker.common.api.shared.context;

import net.jcip.annotations.Immutable;

import org.cspoker.common.api.account.context.AccountContext;
import org.cspoker.common.api.cashier.context.CashierContext;
import org.cspoker.common.api.chat.context.ChatContext;
import org.cspoker.common.api.chat.listener.ChatListener;
import org.cspoker.common.api.lobby.context.LobbyContext;
import org.cspoker.common.api.lobby.listener.LobbyListener;
import org.cspoker.common.elements.table.TableId;

@Immutable
public class ForwardingServerContext implements ServerContext {

	private final ServerContext serverContext;

	public void logout() {
		serverContext.logout();
	}
	
	public ForwardingServerContext(ServerContext serverContext) {
		this.serverContext = serverContext;
	}
	
	public AccountContext getAccountContext() {
		return serverContext.getAccountContext();
	}

	public CashierContext getCashierContext() {
		return serverContext.getCashierContext();
	}

	public ChatContext getServerChatContext(ChatListener chatListener) {
		return serverContext.getServerChatContext(chatListener);
	}

	public ChatContext getTableChatContext(ChatListener chatListener,
			TableId tableId) {
		return serverContext.getTableChatContext(chatListener,tableId);
	}
	
	public LobbyContext getLobbyContext(LobbyListener lobbyListener) {
		return serverContext.getLobbyContext(lobbyListener);
	}
}
