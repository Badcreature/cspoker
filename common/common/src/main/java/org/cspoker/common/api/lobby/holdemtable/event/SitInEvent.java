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

package org.cspoker.common.api.lobby.holdemtable.event;

import net.jcip.annotations.Immutable;

import org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener;
import org.cspoker.common.elements.player.SeatedPlayer;
import org.cspoker.common.elements.table.SeatId;

/**
 * A class to represent player joining games events.
 * 
 */
@Immutable
public class SitInEvent extends HoldemTableEvent {

	private static final long serialVersionUID = 3276571712883586966L;

	private final SeatedPlayer player;

	public SitInEvent(SeatedPlayer player) {
		this.player = player;
	}

	protected SitInEvent() {
		player = null;
	}

	@Override
	public String toString() {
		return player + " sits in.";
	}

	public SeatId getSeatId() {
		return getPlayer().getSeatId();
	}

	public SeatedPlayer getPlayer() {
		return player;
	}
	
	@Override
	public void dispatch(HoldemTableListener holdemTableListener) {
		holdemTableListener.onSitIn(this);
	}

}
