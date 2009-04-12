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
package org.cspoker.client.bots.bot.search.node.leaf;

import org.cspoker.client.bots.bot.search.SearchConfiguration;
import org.cspoker.client.bots.bot.search.node.Distribution;
import org.cspoker.client.bots.bot.search.node.GameTreeNode;
import org.cspoker.client.bots.bot.search.node.visitor.NodeVisitor;
import org.cspoker.client.common.gamestate.GameState;
import org.cspoker.common.elements.player.PlayerId;

public interface ShowdownNode extends LeafNode{

	Distribution getValueDistribution(double lowerBound);

	public static interface Factory {

		ShowdownNode create(PlayerId botId, GameState gameState, int tokens,
				SearchConfiguration config, int searchId,
				NodeVisitor... nodeVisitors);

	}

}