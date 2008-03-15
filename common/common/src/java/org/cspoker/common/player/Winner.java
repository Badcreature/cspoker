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
package org.cspoker.common.player;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Winner implements Serializable {

	private static final long serialVersionUID = 2432656140806034623L;

	private int gainedAmount;

	private Player player;

	public Winner(Player player, int gainedAmount) {
		this.player = player;
		this.gainedAmount = gainedAmount;
	}

	protected Winner() {
		// no op
	}

	public int getGainedAmount() {
		return gainedAmount;
	}

	public Player getPlayer() {
		return player;
	}

	
	public String toString() {
		return player.getName() + " has gained " + gainedAmount + " chips.";
	}

}
