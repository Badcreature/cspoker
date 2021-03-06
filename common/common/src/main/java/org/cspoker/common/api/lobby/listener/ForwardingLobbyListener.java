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
package org.cspoker.common.api.lobby.listener;

import java.util.List;

import org.cspoker.common.api.lobby.event.TableCreatedEvent;
import org.cspoker.common.api.lobby.event.TableRemovedEvent;
import org.cspoker.common.api.shared.listener.ForwardingListener;

public class ForwardingLobbyListener extends ForwardingListener<LobbyListener> implements LobbyListener {
	
	public ForwardingLobbyListener() {
		super();
	}
	
	public ForwardingLobbyListener(List<LobbyListener> listeners) {
		super(listeners);
	}

	public void onTableCreated(TableCreatedEvent tableCreatedEvent) {
		for(LobbyListener listener:listeners){
			listener.onTableCreated(tableCreatedEvent);
		}
	}

	public void onTableRemoved(TableRemovedEvent tableRemovedEvent) {
		for(LobbyListener listener:listeners){
			listener.onTableRemoved(tableRemovedEvent);
		}
	}

}
