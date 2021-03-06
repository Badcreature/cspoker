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
package org.cspoker.common.elements.player;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlValue;

import net.jcip.annotations.Immutable;

@Immutable
public class PlayerId implements Serializable{
	
	private static final long serialVersionUID = 12806955662038980L;
	
	@XmlValue
	private final long playerId;
	
	public PlayerId() {
		this(0);
	}
	
	public PlayerId(long playerId){
		this.playerId = playerId;
	}
	
	public long getId(){
		return playerId;
	}
	
	@Override
	public String toString(){
		return "#"+Long.toString(playerId);
	}

	@Override
	public int hashCode() {
		return (int) (playerId ^ (playerId >>> 32));
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof PlayerId && ((PlayerId) obj).playerId == playerId;
	}

}
