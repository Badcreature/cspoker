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

package org.cspoker.common.events.gameevents;

import java.rmi.RemoteException;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.cspoker.common.eventlisteners.RemoteAllEventsListener;
import org.cspoker.common.player.Player;

/**
 * A class to represent new deal events.
 * 
 * @author Kenzo
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NewDealEvent extends GameEvent {

	private static final long serialVersionUID = 8048593844056212117L;

	private List<Player> players;

	private Player dealer;

	public NewDealEvent(List<Player> players, Player dealer) {
		this.players = Collections.unmodifiableList(players);
		this.dealer = dealer;
	}

	protected NewDealEvent() {
		// no op
	}

	public Player getDealer() {
		return dealer;
	}

	
	public String toString() {
		String toReturn = "A new deal with ";
		for (Player player : players) {
			toReturn += player.getName();
			toReturn += " (";
			toReturn += player.getStackValue();
			toReturn += " chips), ";
		}
		return toReturn.substring(0, toReturn.length() - 2)
				+ " as initial players of this table. " + dealer.getName()
				+ " is dealer.";
	}

	
	public void dispatch(RemoteAllEventsListener listener)
			throws RemoteException {
		listener.onNewDealEvent(this);
	}

}
