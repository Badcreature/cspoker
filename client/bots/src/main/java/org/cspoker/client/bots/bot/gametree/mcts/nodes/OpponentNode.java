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
package org.cspoker.client.bots.bot.gametree.mcts.nodes;

import org.cspoker.client.bots.bot.gametree.action.ProbabilityAction;
import org.cspoker.client.bots.bot.gametree.mcts.strategies.SelectionStrategy;
import org.cspoker.client.bots.bot.gametree.opponentmodel.OpponentModel;
import org.cspoker.client.common.gamestate.GameState;
import org.cspoker.common.elements.player.PlayerId;

public class OpponentNode extends InnerNode{

	public OpponentNode(InnerNode parent, ProbabilityAction probAction,
			GameState gameState, PlayerId bot, Config config) {
		super(parent, probAction, gameState, bot, config);
	}

	@Override
	public INode selectChild(SelectionStrategy strategy) {
		return getRandomChild();
	}	
	
}
