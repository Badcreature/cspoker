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
package org.cspoker.client.common;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import org.apache.log4j.Logger;
import org.cspoker.common.api.lobby.holdemtable.event.*;
import org.cspoker.common.api.lobby.holdemtable.listener.ForwardingHoldemTableListener;
import org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener;
import org.cspoker.common.elements.cards.Card;
import org.cspoker.common.elements.chips.IllegalValueException;
import org.cspoker.common.elements.chips.Pots;
import org.cspoker.common.elements.player.MutableSeatedPlayer;
import org.cspoker.common.elements.player.PlayerId;
import org.cspoker.common.elements.player.SeatedPlayer;
import org.cspoker.common.elements.table.Rounds;

@ThreadSafe
public class SmartHoldemTableListener
extends ForwardingHoldemTableListener {

	private final static Logger logger = Logger.getLogger(SmartHoldemTableListener.class);

	private volatile Pots pots;
	private volatile Set<Card> communityCards;
	private volatile Rounds round;

	@GuardedBy("playersLock")
	private final HashMap<PlayerId, MutableSeatedPlayer> players = new HashMap<PlayerId, MutableSeatedPlayer>();

	private final Object playersLock = new Object();

	public SmartHoldemTableListener(HoldemTableListener holdemTableListener) {
		super(holdemTableListener);
	}

	public Pots getPots() {
		return pots;
	}

	public Set<Card> getCommunityCards() {
		return communityCards;
	}

	public Rounds getCurrentRound() {
		return round;
	}

	@Override
	public void onNewCommunityCards(NewCommunityCardsEvent newCommunityCardsEvent) {
		this.communityCards = newCommunityCardsEvent.getCommunityCards();
		super.onNewCommunityCards(newCommunityCardsEvent);
	}

	@Override
	public void onNewRound(NewRoundEvent newRoundEvent) {
		this.round = newRoundEvent.getRound();
		pots = newRoundEvent.getPots();
		synchronized (playersLock) {
			for (MutableSeatedPlayer player : players.values()) {
				player.getBetChips().discard();
			}
		}
		super.onNewRound(newRoundEvent);
	}

	@Override
	public void onNewDeal(NewDealEvent newDealEvent) {
		List<SeatedPlayer> seatedPlayers = newDealEvent.getPlayers();
		pots = null;
		synchronized (playersLock) {
			players.clear();
			for (SeatedPlayer seatedPlayer : seatedPlayers) {
				try {
					players.put(seatedPlayer.getId(), new MutableSeatedPlayer(seatedPlayer));
				} catch (IllegalArgumentException e) {
					logger.error(e);
					throw new IllegalStateException(e);
				}
			}
		}
		super.onNewDeal(newDealEvent);
	}

	@Override
	public void onAllIn(AllInEvent allInEvent) {
		logger.trace(allInEvent);
		synchronized (playersLock) {
			try {
				players.get(allInEvent.getPlayerId()).transferAllChipsToBetPile();
			} catch (IllegalArgumentException e) {
				logger.error(e);
				throw new IllegalStateException(e);
			}
		}
		super.onAllIn(allInEvent);
	}

	@Override
	public void onBet(BetEvent betEvent) {
		logger.trace(betEvent);
		addToBet(betEvent.getPlayerId(), betEvent.getAmount());
		super.onBet(betEvent);
	}

	@Override
	public void onBigBlind(BigBlindEvent bigBlindEvent) {
		logger.trace(bigBlindEvent);
		addToBet(bigBlindEvent.getPlayerId(), bigBlindEvent.getAmount());
		super.onBigBlind(bigBlindEvent);
	}

	@Override
	public void onSmallBlind(SmallBlindEvent smallBlindEvent) {
		logger.trace(smallBlindEvent);
		addToBet(smallBlindEvent.getPlayerId(), smallBlindEvent.getAmount());
		super.onSmallBlind(smallBlindEvent);
	}

	@Override
	public void onCall(CallEvent callEvent) {
		logger.trace(callEvent);
		synchronized (playersLock) {
			addToBet(callEvent.getPlayerId(), getDeficit(callEvent.getPlayerId()));
		}
		super.onCall(callEvent);
	}

	@Override
	public void onRaise(RaiseEvent raiseEvent) {
		logger.trace(raiseEvent);
		synchronized (playersLock) {
			addToBet(raiseEvent.getPlayerId(), getDeficit(raiseEvent.getPlayerId()) + raiseEvent.getAmount());
		}
		super.onRaise(raiseEvent);
	}

	public int getDeficit(PlayerId playerId) {
		synchronized (playersLock) {
			return Math.min(players.get(playerId).getBetChips().getValue(), getMaxBet()
					- players.get(playerId).getBetChips().getValue());
		}
	}

	public int getMaxBet() {
		synchronized (playersLock) {
			int max = 0;
			for (MutableSeatedPlayer player : players.values()) {
				if (player.getBetChips().getValue() > max) {
					max = player.getBetChips().getValue();
				}
			}
			return max;
		}
	}

	private void addToBet(PlayerId playerId, int amount) {
		synchronized (playersLock) {
			try {
				players.get(playerId).transferAmountToBetPile(amount);
			} catch (IllegalValueException e) {
				logger.error(e);
				throw new IllegalStateException(e);
			}
		}
	}

	public boolean isPlaying(PlayerId playerID) {
		synchronized (playersLock) {
			return players.containsKey(playerID);
		}
	}

	@Override
	public void onSitOut(SitOutEvent sitOutEvent) {
		synchronized (playersLock) {
			players.remove(sitOutEvent.getPlayerId());
		}
		super.onSitOut(sitOutEvent);
	}

	public int getAllStakes(PlayerId playerID) {
		synchronized (playersLock) {
			MutableSeatedPlayer player = players.get(playerID);
			if(player==null){
				return 0;
			}else{
				if(getPots()!=null && getPots().getTotalValue()>0){
					throw new IllegalStateException("Pots are not empty, can't calculate all stakes");
				}
				return player.getStack().getValue()+player.getBetChips().getValue();
			}
		}
	}
}
