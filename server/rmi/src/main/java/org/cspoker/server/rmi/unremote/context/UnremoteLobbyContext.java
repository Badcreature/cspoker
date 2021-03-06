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
package org.cspoker.server.rmi.unremote.context;

import org.cspoker.common.api.lobby.context.ExternalLobbyContext;
import org.cspoker.common.api.lobby.context.ForwardingLobbyContext;
import org.cspoker.common.api.lobby.context.LobbyContext;
import org.cspoker.common.api.lobby.holdemtable.context.ExternalHoldemTableContext;
import org.cspoker.common.api.lobby.holdemtable.context.HoldemTableContext;
import org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener;
import org.cspoker.common.api.lobby.holdemtable.listener.RemoteHoldemTableListener;
import org.cspoker.common.api.shared.Trigger;
import org.cspoker.common.api.shared.exception.IllegalActionException;
import org.cspoker.common.elements.table.TableId;
import org.cspoker.server.rmi.unremote.listener.UnremoteHoldemTableListener;

public class UnremoteLobbyContext extends ForwardingLobbyContext implements
ExternalLobbyContext {

	private final Trigger connection;
	
	public UnremoteLobbyContext(Trigger connection, LobbyContext lobbyContext) {
		super(lobbyContext);
		this.connection = connection;
	}
	
	public ExternalHoldemTableContext joinHoldemTable(TableId tableId,
			RemoteHoldemTableListener holdemTableListener) throws IllegalActionException {
		HoldemTableContext context = super.joinHoldemTable(tableId, new UnremoteHoldemTableListener(connection,holdemTableListener));
		return new UnremoteHoldemTableContext(connection, context);
	}
	
	@Override
	public ExternalHoldemTableContext joinHoldemTable(TableId tableId,
			HoldemTableListener holdemTableListener)
			throws IllegalActionException {
		HoldemTableContext context = super.joinHoldemTable(tableId, holdemTableListener);
		return new UnremoteHoldemTableContext(connection, context);
	}
	
}
