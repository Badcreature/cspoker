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
package org.cspoker.client.bots.bot.gametree.mcts.strategies;

import org.cspoker.client.bots.bot.gametree.mcts.nodes.INode;
import org.cspoker.client.bots.bot.gametree.mcts.nodes.InnerNode;

public class SamplingToFunctionSelector implements SelectionStrategy {

	private final MaxFunctionSelector functionSelector;

	public SamplingToFunctionSelector(MaxFunctionSelector functionSelector) {
		this.functionSelector = functionSelector;
	}
	
	@Override
	public INode select(InnerNode innerNode) {
		if(innerNode.getNbSamples()<100){
			return innerNode.getRandomChild();
		}else{
			return functionSelector.select(innerNode);
		}
	}

}
