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
package org.cspoker.common.api.lobby.holdemtable.holdemplayer.event;

import java.util.EnumSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import net.jcip.annotations.Immutable;

import org.cspoker.common.api.lobby.holdemtable.holdemplayer.listener.HoldemPlayerListener;
import org.cspoker.common.elements.cards.Card;

@Immutable
public class NewPocketCardsEvent extends HoldemPlayerEvent {

	private static final long serialVersionUID = -3328895783353781276L;

	//JAXB doesn't like EnumSets
	@XmlElementWrapper
	@XmlElement(name = "card")
	private final Set<Card> pocketCards;

	public NewPocketCardsEvent(EnumSet<Card> pocketCards) {
		this.pocketCards = EnumSet.copyOf(pocketCards);
	}

	protected NewPocketCardsEvent() {
		pocketCards = null;
	}

	public EnumSet<Card> getPocketCards() {
		return EnumSet.copyOf(pocketCards);
	}

	@Override
	public String toString() {
		String toReturn = "You have received new pocket cards: ";
		for (Card card : getPocketCards()) {
			toReturn += card;
			toReturn += ", ";
		}
		return toReturn.substring(0, toReturn.length() - 2) + ".";
	}
	
	@Override
	public void dispatch(HoldemPlayerListener holdemPlayerListener) {
		holdemPlayerListener.onNewPocketCards(this);
	}
	
}
