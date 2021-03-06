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

package org.cspoker.common.elements.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.cspoker.common.util.random.RandomOrgSeededRandomGenerator;

/**
 * A class to represent a deck of cards.
 * 
 */
public class Deck {

	/*
	 * Sorted prototype deck for copying
	 */
	private static final Set<Card> PROTO_DECK;

	static {
		// Initialize prototype deck
		PROTO_DECK = Collections.unmodifiableSet(EnumSet.allOf(Card.class));
	}

	public static Deck createTruelyRandomDeck(){
		List<Card> cards = new ArrayList<Card>(Deck.PROTO_DECK);
		Collections.shuffle(cards, RandomOrgSeededRandomGenerator.getInstance()
				.getRandom());	
		return new Deck(cards);
	}

	public static Deck createWeaklyRandomDeck(){
		List<Card> cards = new ArrayList<Card>(Deck.PROTO_DECK);
		Collections.shuffle(cards);	
		return new Deck(cards);
	}
	
	
	/**
	 * The sequence of cards in this deck.
	 */
	private final List<Card> cards;
	
	/**
	 * Construct a new deck of cards and shuffle it.
	 */
	private Deck(List<Card> cards) {
		this.cards = cards;
	}

	public Deck(Deck copy) {
		this(new ArrayList<Card>(copy.cards));
	}

	/**
	 * Returns a list of Cards removed from the deck. This method is not
	 * thread-safe. Since the deck is modified, it is important to synchronize
	 * on the deck in multi-threaded programs.
	 * 
	 * @param number
	 *            number of cards to return
	 * @return {@link List} of Cards
	 */
	public synchronized List<Card> deal(final int number) {
		final int deckSize = cards.size();
		final List<Card> handView = cards.subList(deckSize - number, deckSize);
		final ArrayList<Card> hand = new ArrayList<Card>(handView);
		handView.clear();
		return hand;
	}
	
	/**
	 * Draw the card on the top of this deck.
	 * 
	 * @post The second card in the deck becomes the new top card
	 * @result The top card from the deck is returned
	 */
	public synchronized Card drawCard() {
		return deal(1).get(0);
	}
	
	/**
	 * Returns the textual representation of this deck.
	 */

	@Override
	public String toString() {
		return cards.toString();
	}
}
