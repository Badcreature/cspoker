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
package org.cspoker.server.embedded.gamecontrol.rules;

import org.cspoker.server.embedded.gamecontrol.rounds.BettingRound;

/**
 * Class for the NoLimit betting game.rounds.rules used in Texas Hold'em.
 * 
 * @author Cedric
 */
public class NoLimit extends BettingRules {
	/***************************************************************************
	 * Constructors
	 **************************************************************************/

	public NoLimit() {
	}

	/***************************************************************************
	 * Raise
	 **************************************************************************/

	@Override
	public boolean isValidRaise(int amount, BettingRound round) {
		if (amount < getLastBetAmount()) {
			setLastRaiseErrorMessage("ERROR : the bet amount must be at least the amount of the previous bet/raise"
					+ " in the current round");
			return false;
		}
		return super.isValidRaise(amount, round);
	}

	@Override
	public String toString() {
		return "Hold'em No Limit";
	}
}
