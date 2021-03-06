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
package org.cspoker.ai.bots.bot.gametree.search.nodevisitor;

import org.cspoker.ai.bots.bot.gametree.action.ActionWrapper;
import org.cspoker.ai.bots.bot.gametree.search.Distribution;
import org.cspoker.ai.bots.bot.gametree.search.GameTreeNode;
import org.cspoker.client.common.gamestate.GameState;
import org.cspoker.common.elements.player.PlayerId;
import org.cspoker.common.util.Pair;

public interface NodeVisitor {

	void enterNode(Pair<ActionWrapper,GameTreeNode> node, double lowerBound);

	void leaveNode(Pair<ActionWrapper,GameTreeNode> node, Distribution distribution);
	
	void pruneSubTree(Pair<ActionWrapper,GameTreeNode> node, Distribution distribution, double lowerBound);

	void visitLeafNode(int winnings, double probability, int minWinnable,
			int maxWinnable);
	
	void callOpponentModel();

	public static interface Factory {

		NodeVisitor create(GameState gameState, PlayerId actor);

	}

}
