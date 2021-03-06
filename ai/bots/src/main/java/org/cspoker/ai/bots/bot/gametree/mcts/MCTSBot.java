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
package org.cspoker.ai.bots.bot.gametree.mcts;

import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.cspoker.ai.bots.bot.AbstractBot;
import org.cspoker.ai.bots.bot.gametree.action.DefaultWinnerException;
import org.cspoker.ai.bots.bot.gametree.action.GameEndedException;
import org.cspoker.ai.bots.bot.gametree.action.SearchBotAction;
import org.cspoker.ai.bots.bot.gametree.mcts.listeners.MCTSListener;
import org.cspoker.ai.bots.bot.gametree.mcts.nodes.Config;
import org.cspoker.ai.bots.bot.gametree.mcts.nodes.INode;
import org.cspoker.ai.bots.bot.gametree.mcts.nodes.InnerNode;
import org.cspoker.ai.bots.bot.gametree.mcts.nodes.RootNode;
import org.cspoker.ai.bots.listener.BotListener;
import org.cspoker.client.common.SmartLobbyContext;
import org.cspoker.client.common.gamestate.AbstractGameState;
import org.cspoker.client.common.gamestate.ForwardingGameState;
import org.cspoker.client.common.gamestate.GameState;
import org.cspoker.common.api.shared.exception.IllegalActionException;
import org.cspoker.common.elements.player.PlayerId;
import org.cspoker.common.elements.table.TableId;

import com.google.common.collect.ImmutableList;

//import org.cspoker.common.elements.table.Round;

public class MCTSBot extends AbstractBot {

	private final static Logger logger = Logger.getLogger(MCTSBot.class);
	private final Config config;
	private final MCTSListener.Factory[] MCTSlistenerFactories;
	private final int decisionTime;

	long startTime = System.currentTimeMillis();
	
	public MCTSBot(PlayerId botId, TableId tableId,
			SmartLobbyContext lobby, ExecutorService executor, int buyIn, 
			Config config,
			int decisionTime,
			MCTSListener.Factory[] MCTSlisteners, 
			BotListener... botListeners) {
		super(botId, tableId, lobby, buyIn, executor, botListeners);
		this.config = config;
		this.MCTSlistenerFactories = MCTSlisteners;
		this.decisionTime = decisionTime;
	}
	
	public Config getConfig() {
		return config;
	}

	@Override
	public void doNextAction() throws RemoteException, IllegalActionException {
		startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis()+decisionTime;
		GameState gameState = tableContext.getGameState();	
		RootNode root = new RootNode(gameState,botId,config);
		logger.info("Starting MCTS iterations.");
		do{
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
			iterate(root);
		}while(System.currentTimeMillis()<endTime);
		INode node = root.selectChild(config.getMoveSelectionStrategy());
		config.getModel().setChosenNode(node);
//		try {
//		ImmutableList<INode> children = ((InnerNode) node).getChildren();
//		for (INode n: children) {
//			String str = " <last action> ";
//			str = "" + n.getLastAction().getAction().getUnwrappedStateAfterAction().getClass();
//			System.out.println("Child " +  str
//					+ " with action " + n.getLastAction().getAction() + " with probability " +
//					n.getLastAction().getProbability());
//		}
//		} catch (ClassCastException e) {
//			System.out.println("-------------\nNO CLASS CAST\n-------------"); // do nothing
//		}
		SearchBotAction action = node.getLastAction().getAction();
		if(logger.isInfoEnabled()) 
			logger.info("Stopped MCTS after "+root.getNbSamples()+" samples and choosing "+action);
		
		// to calculate efficiency of sampling algorithms
//		if (tableContext.getGameState().getRound() == Round.PREFLOP)
//			System.out.print(root.getNbSamples());
//		System.out.print("\t");
//		if (tableContext.getGameState().getRound() == Round.FLOP)
//			System.out.print(root.getNbSamples());
//		System.out.print("\t");
//		if (tableContext.getGameState().getRound() == Round.TURN)= 
//			System.out.print(root.getNbSamples());
//		System.out.print("\t");
//		if (tableContext.getGameState().getRound() == Round.FINAL)
//			System.out.print(root.getNbSamples());
//		System.out.println("");
		
		action.perform(playerContext);
		MCTSListener[] listeners = createListeners(gameState, botId);
		for (MCTSListener listener : listeners) {
			listener.onMCTS(root);
		}
	}

	private void iterate(RootNode root) {
		INode selectedLeaf = root.selectRecursively();
		selectedLeaf.expand();
		double value = selectedLeaf.simulate();
		selectedLeaf.backPropagate(value);
	}

	private MCTSListener[] createListeners(GameState gameState, PlayerId actor) {
		MCTSListener[] listeners = new MCTSListener[MCTSlistenerFactories.length];
		for (int i=0;i<MCTSlistenerFactories.length;i++) {
			listeners[i] = MCTSlistenerFactories[i].create(gameState, actor);
		}
		return listeners;
	}

}
