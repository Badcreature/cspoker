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
package org.cspoker.client.common.gamestate.modifiers;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import org.cspoker.client.common.gamestate.AbstractPlayerState;
import org.cspoker.client.common.gamestate.ForwardingGameState;
import org.cspoker.client.common.gamestate.GameState;
import org.cspoker.client.common.gamestate.GameStateVisitor;
import org.cspoker.client.common.gamestate.PlayerState;
import org.cspoker.common.api.lobby.holdemtable.event.HoldemTableEvent;
import org.cspoker.common.api.lobby.holdemtable.event.SitInEvent;
import org.cspoker.common.elements.cards.Card;
import org.cspoker.common.elements.player.PlayerId;
import org.cspoker.common.elements.table.SeatId;

import com.google.common.collect.ImmutableBiMap;

public class SitInState
		extends ForwardingGameState {
	
	private final SitInEvent event;
	private final PlayerState playerState;
	private final ImmutableBiMap<SeatId, PlayerId> seatMap;
	
	public SitInState(GameState gameState, SitInEvent event) {
		super(gameState);
		this.event = event;
		playerState = new AbstractPlayerState() {
			
			public int getBet() {
				return 0;
			}
			
			public EnumSet<Card> getCards() {
				return EnumSet.noneOf(Card.class);
			}
			
			public PlayerId getPlayerId() {
				return SitInState.this.event.getPlayer().getId();
			}
			
			public SeatId getSeatId() {
				return SitInState.this.event.getPlayer().getSeatId();
			}
			
			public int getStack() {
				return SitInState.this.event.getPlayer().getStackValue();
			}
			
			public boolean hasFolded() {
				return false;
			}
			
			public boolean sitsIn() {
				return true;
			}
			
			@Override
			public boolean isPlayingGame() {
				return false;
			}
			
			@Override
			public boolean isSmallBlind() {
				return false;
			}
			
			@Override
			public boolean isBigBlind() {
				return false;
			}
			
			@Override
			public boolean hasChecked() {
				return false;
			}
			
			/**
			 * {@inheritDoc}
			 */
			@Override
			public List<Integer> getBetProgression() {
				return Collections.emptyList();
			}
			
		};
		
		seatMap = new ImmutableBiMap.Builder<SeatId,PlayerId>()
			.putAll(gameState.getSeatMap())
			.put(event.getPlayer().getSeatId(), event.getPlayer().getId())
			.build();
	}
	
	@Override
	public PlayerState getPlayer(PlayerId playerId) {
		if (event.getPlayer().getId().equals(playerId)) {
			return playerState;
		}
		return super.getPlayer(playerId);
	}
	
	@Override
	public ImmutableBiMap<SeatId, PlayerId> getSeatMap() {
		return seatMap;
	}
	
	public HoldemTableEvent getLastEvent() {
		return event;
	}
	
	public SitInEvent getEvent() {
		return event;
	}
	
	@Override
	public void acceptVisitor(GameStateVisitor visitor) {
		visitor.visitSitInState(this);
	}
	
}
