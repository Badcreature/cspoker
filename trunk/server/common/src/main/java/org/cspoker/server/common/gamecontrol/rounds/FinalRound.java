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

package org.cspoker.server.common.gamecontrol.rounds;

import org.apache.log4j.Logger;
import org.cspoker.common.api.lobby.holdemtable.event.NewRoundEvent;
import org.cspoker.common.api.lobby.holdemtable.event.NextPlayerEvent;
import org.cspoker.common.elements.table.Rounds;
import org.cspoker.server.common.gamecontrol.Game;
import org.cspoker.server.common.gamecontrol.PokerTable;
import org.cspoker.server.common.gamecontrol.Showdown;
import org.cspoker.server.common.player.GameSeatedPlayer;

public class FinalRound extends BettingRound {
	private static Logger logger = Logger.getLogger(FinalRound.class);

	public FinalRound(PokerTable gameMediator, Game game) {
		super(gameMediator, game);
		
		GameSeatedPlayer currentPlayer = game.getCurrentPlayer();
		if (currentPlayer != null) {
			gameMediator.publishNewRoundEvent(new NewRoundEvent(getRound()));
			gameMediator.publishNextPlayerEvent(new NextPlayerEvent(currentPlayer.getMemento()));
		}
		drawMuckCard();
		drawOpenCardAndPublishCommonCard();
		FinalRound.logger.info("*** RIVER *** " + game.getCommunityCards());
	}

	public void endRound() {
		if (onlyOnePlayerLeft()) {
			super.endRound();
		} else {
			collectChips();
			game.getPots().close(game.getCurrentDealPlayers());
			Showdown showdown = new Showdown(gameMediator, getGame());
			showdown.determineWinners();
			game.showdownOccured(showdown.getNbShowdownPlayers());
		}
		removeBrokePlayers();
		game.initializeForNewHand();
	}

	public Round getNextRound() {
		return getNewDealRound();
	}

	public boolean isLowBettingRound() {
		return false;
	}

	public boolean isHighBettingRound() {
		return !isLowBettingRound();
	}

	public String toString() {
		return "final round";
	}
	
	public Rounds getRound(){
		return Rounds.FINAL;
	}
}
