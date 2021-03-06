package org.cspoker.server.embedded;

import org.cspoker.common.api.lobby.context.LobbyContext;
import org.cspoker.common.api.lobby.holdemtable.context.HoldemTableContext;
import org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener;
import org.cspoker.common.api.lobby.listener.LobbyListener;
import org.cspoker.common.api.shared.exception.IllegalActionException;
import org.cspoker.common.elements.table.DetailedHoldemTable;
import org.cspoker.common.elements.table.TableConfiguration;
import org.cspoker.common.elements.table.TableId;
import org.cspoker.common.elements.table.TableList;
import org.cspoker.server.embedded.account.ExtendedAccountContext;
import org.cspoker.server.embedded.lobby.Lobby;

public class LobbyContextImpl
		implements LobbyContext {
	
	private ExtendedAccountContext accountContext;
	private Lobby lobby;
	
	public LobbyContextImpl(ExtendedAccountContext accountContext, Lobby lobby) {
		this.accountContext = accountContext;
		this.lobby = lobby;
	}
	
	public DetailedHoldemTable createHoldemTable(String name, TableConfiguration configuration) {
		return lobby.createTable(accountContext, name, configuration);
	}
	
	public DetailedHoldemTable getHoldemTableInformation(TableId tableId) {
		return lobby.getTableInformation(tableId);
	}
	
	public TableList getTableList() {
		return lobby.getTableList();
	}
	
	public HoldemTableContext joinHoldemTable(TableId tableId, HoldemTableListener holdemTableListener)
			throws IllegalActionException {
		return lobby.joinTable(tableId, holdemTableListener, accountContext);
	}
	
	public void subscribe(LobbyListener lobbyListener) {
		lobby.subscribe(lobbyListener);
	}
	
	public void unSubscribe(LobbyListener lobbyListener) {
		lobby.unSubscribe(lobbyListener);
	}
	
}
