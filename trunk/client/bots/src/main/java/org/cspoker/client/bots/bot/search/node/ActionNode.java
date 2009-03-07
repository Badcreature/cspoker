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
package org.cspoker.client.bots.bot.search.node;

import org.apache.log4j.Logger;
import org.cspoker.client.bots.bot.search.SearchConfiguration;
import org.cspoker.client.bots.bot.search.action.ActionWrapper;
import org.cspoker.client.bots.bot.search.action.DefaultWinnerException;
import org.cspoker.client.bots.bot.search.action.EvaluatedAction;
import org.cspoker.client.bots.bot.search.action.GameEndedException;
import org.cspoker.client.bots.bot.search.node.leaf.ShowdownNode;
import org.cspoker.client.bots.bot.search.node.visitor.NodeVisitor;
import org.cspoker.client.bots.bot.search.opponentmodel.AllPlayersModel;
import org.cspoker.client.common.gamestate.GameState;
import org.cspoker.common.elements.player.PlayerId;

public abstract class ActionNode implements InnerGameTreeNode{

	private final static Logger logger = Logger.getLogger(ActionNode.class);

	protected final GameState gameState;
	protected final PlayerId playerId;
	protected final PlayerId botId;

	protected final NodeVisitor[] visitors;
	protected final SearchConfiguration config;
	protected final int searchId;

	public ActionNode(PlayerId playerId, PlayerId botId, GameState gameState, 
			SearchConfiguration config, int searchId, NodeVisitor... visitors) {
		this.gameState = gameState;
		this.playerId = playerId;
		this.visitors =  visitors;
		this.botId= botId;
		this.config = config;
		this.searchId = searchId;
	}

	public <A extends ActionWrapper> EvaluatedAction<A> expandWith(A action, int tokens){
		for(NodeVisitor visitor:visitors){
			visitor.enterNode(this, action, tokens);
		}
		EvaluatedAction<A> result;
		GameState nextState;

		if(action.getAction().endsInvolvementOf(botId)){
			//bot folded
			int stack = action.getAction().gameState.getPlayer(botId).getStack();
			result = new EvaluatedAction<A>(action, stack,0);
		}else{
			try {
				nextState = action.getAction().getStateAfterAction();
				//expand further
				PlayerId nextToAct = nextState.getNextToAct();
				if(nextToAct.equals(botId)){
					//go to next player node
					BotActionNode botActionNode = new BotActionNode(botId, nextState, config, tokens, searchId, visitors);
					result = new EvaluatedAction<A>(action, botActionNode.getEV());
				}else{	
					OpponentActionNode opponentActionNode = new OpponentActionNode(nextToAct, botId, nextState, config, tokens, searchId, visitors);
					result = new EvaluatedAction<A>(action, opponentActionNode.getEV());
				}
			} catch (GameEndedException e) {
				//no active players left
				//go to showdown
				ShowdownNode showdownNode = config.getShowdownNodeFactory().create(botId, e.lastState, tokens, config, searchId);
				result = new EvaluatedAction<A>(action, showdownNode.getExpectedValue());
			} catch (DefaultWinnerException e) {
				if(e.winner.getPlayerId().equals(botId)){
					//bot wins
					int stack = e.winner.getStack();
					int pots = e.foldState.getGamePotSize();
					result = new EvaluatedAction<A>(action, stack+pots,0);
				}else{
					throw new IllegalStateException("Bot should have folded earlier, winner can't be "+e.winner);
				}
			} 
		}
		for(NodeVisitor visitor:visitors){
			visitor.leaveNode(result);
		}
		return result;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}

	public AllPlayersModel getOpponentModeler() {
		return config.getOpponentModeler();
	}

	@Override
	public GameState getGameState() {
		return gameState;
	}

	@Override
	public String toString() {
		return "Action Node";
	}

}
