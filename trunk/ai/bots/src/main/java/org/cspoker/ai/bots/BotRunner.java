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
package org.cspoker.ai.bots;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;

import javax.security.auth.login.LoginException;

import net.jcip.annotations.NotThreadSafe;

import org.apache.log4j.Logger;
import org.cspoker.ai.bots.bot.Bot;
import org.cspoker.ai.bots.bot.BotFactory;
import org.cspoker.ai.bots.bot.gametree.mcts.MCTSBotFactory;
import org.cspoker.ai.bots.bot.gametree.mcts.nodes.MCTSBucketShowdownNode;
import org.cspoker.ai.bots.bot.gametree.mcts.strategies.backpropagation.MaxDistributionPlusBackPropStrategy;
import org.cspoker.ai.bots.bot.gametree.mcts.strategies.backpropagation.MixedBackPropStrategy;
import org.cspoker.ai.bots.bot.gametree.mcts.strategies.backpropagation.SampleWeightedBackPropStrategy;
import org.cspoker.ai.bots.bot.gametree.mcts.strategies.selection.MaxValueSelector;
import org.cspoker.ai.bots.bot.gametree.mcts.strategies.selection.SamplingSelector;
import org.cspoker.ai.bots.bot.gametree.mcts.strategies.selection.SamplingToFunctionSelector;
import org.cspoker.ai.bots.bot.gametree.mcts.strategies.selection.UCTPlusPlusSelector;
import org.cspoker.ai.bots.bot.gametree.mcts.strategies.selection.UCTSelector;
import org.cspoker.ai.bots.listener.BotListener;
import org.cspoker.ai.bots.listener.CSVLogListener;
import org.cspoker.ai.bots.listener.GameLimitingBotListener;
import org.cspoker.ai.bots.listener.ReSitInBotListener;
import org.cspoker.ai.bots.listener.SpeedTestBotListener;
import org.cspoker.ai.bots.util.CombinationGenerator;
import org.cspoker.ai.opponentmodels.weka.WekaRegressionModelFactory;
import org.cspoker.client.common.SmartClientContext;
import org.cspoker.client.common.SmartLobbyContext;
import org.cspoker.common.RemoteCSPokerServer;
import org.cspoker.common.api.lobby.event.TableCreatedEvent;
import org.cspoker.common.api.lobby.event.TableRemovedEvent;
import org.cspoker.common.api.lobby.listener.DefaultLobbyListener;
import org.cspoker.common.api.lobby.listener.LobbyListener;
import org.cspoker.common.api.shared.exception.IllegalActionException;
import org.cspoker.common.elements.player.PlayerId;
import org.cspoker.common.elements.table.TableConfiguration;
import org.cspoker.common.elements.table.TableId;
import org.cspoker.common.util.Log4JPropertiesLoader;
import org.cspoker.common.util.threading.GlobalThreadPool;
import org.cspoker.common.util.threading.SingleThreadRequestExecutor;

@NotThreadSafe
public class BotRunner implements LobbyListener {

	private static final int nbBigBlindsBuyIn = 0; //0 for Doyle's Game -> 200
	private static final TableConfiguration config = new TableConfiguration(100,
			0, false, true, true);

	public static final int nbGamesPerConfrontation = 1000000;
	public final int nbPlayersPerGame;

	public static final int reportInterval = 10;

	static {
		Log4JPropertiesLoader
		.load("org/cspoker/client/bots/logging/log4j.properties");
	}

	private final static Logger logger = Logger.getLogger(BotRunner.class);

	private final BotFactory[] botFactories;

	private final SmartLobbyContext[] botLobbies;
	private final PlayerId[] botIDs;

	protected final SmartLobbyContext directorLobby;

	private final ExecutorService executor;

	private volatile Bot[] bot;

	private volatile int[] botIndex;

	private BotListener speedMonitor;
	private CSVLogListener csvLogger;
	private volatile BotListener gameLimiter;

	private final CombinationGenerator combinationgenerator;

	public static BotRunner create(RemoteCSPokerServer cspokerServer) {
		try {
			if(false){
				//hide compiler warnings
				throw new IOException();
			}
			if(false){
				throw new ClassNotFoundException();
			}
			return new BotRunner(cspokerServer,
					new BotFactory[] {
//					new CallBotFactory(),
//					new CardBotFactory("CardBot"),
//					new HandBotFactory("HandBot"),
					new MCTSBotFactory(
							"Plus Bot",
							WekaRegressionModelFactory.createForZip("org/cspoker/client/bots/bot/search/opponentmodel/weka/models/model1.zip"),
							new SamplingToFunctionSelector(50,new UCTSelector(40000)),
							new SamplingToFunctionSelector(250,new UCTPlusPlusSelector()),
							new MaxValueSelector(),
							new MCTSBucketShowdownNode.Factory(),
							new MixedBackPropStrategy.Factory(
									100,
									new SampleWeightedBackPropStrategy.Factory(),
									new MaxDistributionPlusBackPropStrategy.Factory()
							),
							300
					),
					new MCTSBotFactory(
							"MaxDistribution Bot",
							WekaRegressionModelFactory.createForZip("org/cspoker/client/bots/bot/search/opponentmodel/weka/models/model1.zip"),
							new SamplingToFunctionSelector(50,new UCTSelector(40000)),
							new SamplingSelector(),
							new MaxValueSelector(),
							new MCTSBucketShowdownNode.Factory(),
							new SampleWeightedBackPropStrategy.Factory(),
							300
					),
					//					new CallBotFactory(),
					//					new CardBotFactory("CardBot"),
					//					new HandBotFactory("HandBot"),
					//					new SearchBotFactory(
					//							new WekaRegressionModelFactory("/home/guy/Werk/thesis/weka-3-6-0/model1"),
					//							new ShowdownBucketRolloutNode.Factory(),
					//							200, 600, 1000, 3000, 0, false, true
					//					),
					//					new MCTSBotFactory(
					//							"MCTS Bot",
					//							new WekaRegressionModelFactory("/home/guy/Werk/thesis/weka-3-6-0/model1"),
					//							new SamplingToFunctionSelector(20,new UCTSelector(40000)),
					//							new SamplingSelector(),
					//							new MaxValueSelector(),
					//							new MCTSBucketShowdownNode.Factory(),
					//							new SampleWeightedBackPropStrategy.Factory(),
					//							2000
					//					),
					//					new MCTSBotFactory(
					//							"Bot 2",
					//							new WekaRegressionModelFactory("/home/guy/Werk/thesis/weka-3-6-0/model1"),
					//							new SamplingToFunctionSelector(10,new UCTPlusSelector(2000,0.5)),
					//							new MixedSelectionStrategy(new SamplingSelector(), new MinValueSelector(),0.95),
					//							new MaxUnderValueSelector(2),
					//							new MCTSBucketShowdownNode.Factory(),
					//							new MixtureBackPropStrategy.Factory(new MaxUnderValueSelector(2)),
					//							250
					//					),
					//					new MCTSBotFactory(
					//							"Bot 3",
					//							new WekaRegressionModelFactory("/home/guy/Werk/thesis/weka-3-6-0/model1"),
					//							new SamplingToFunctionSelector(10,new UCTSelector(20000)),
					//							new MixedSelectionStrategy(new SamplingSelector(), new MinValueSelector(),0.95),
					//							new MaxUnderValueSelector(2),
					//							new MCTSBucketShowdownNode.Factory(),
					//							new MixtureBackPropStrategy.Factory(new MaxUnderValueSelector(2)),
					//							250
					//					),
					//					new MCTSBotFactory(
					//							"Bot 4",
					//							new WekaRegressionModelFactory("/home/guy/Werk/thesis/weka-3-6-0/model1"),
					//							new SamplingToFunctionSelector(10,new UCTPlusSelector(20000,0.5)),
					//							new MixedSelectionStrategy(new SamplingSelector(), new MinValueSelector(),0.95),
					//							new MaxUnderValueSelector(2),
					//							new MCTSBucketShowdownNode.Factory(),
					//							new MixtureBackPropStrategy.Factory(new MaxUnderValueSelector(2)),
					//							250
					//					),
					//					new MCTSBotFactory(
					//							"Bot B",
					//							new WekaRegressionModelFactory("/home/guy/Werk/thesis/weka-3-6-0/model1"),
					//							new SamplingToFunctionSelector(new UCTSelector(5000)),
					//							new SampleProportionateSelector(),
					//							new MCTSBucketShowdownNode.Factory(),
					//							50),
					// ML bots
					//						 new RuleBasedBotFactory1(),
					//				new RuleBasedBotFactory2(),
					//				new SearchBotFactory(new ShowdownRolloutNode.Factory(new DistributionRollout4.Factory())),
					//				new MCTSBotFactory(),
					//				 new SearchBotFactory(new
					//				 DistributionShowdownNode4.Factory()),
					// new RuleBasedBotFactory1(),
					// new RuleBasedBotFactory2(),

					// new SearchBotFactory(new
					// DistributionShowdownNode1.Factory()),
					// new SearchBotFactory(new
					// DistributionShowdownNode2.Factory()),
					// new SearchBotFactory(new
					// DistributionShowdownNode4.Factory()),
					// new RuleBasedBotFactory(),
					//						new PrologCafeBotFactory(
					//								new DistributionShowdownNode4.Factory()),
					//				new WekaClassificationBotFactory(
					//						new DistributionShowdownNode4.Factory(),
					//						"/home/guy/Bureaublad/weka-3-6-0/ANN-c-cb.model",
					//						"/home/guy/Bureaublad/weka-3-6-0/ANN-c-fcr.model"
					//				),
					//				new WekaRegressionBotFactory(
					//						new ShowdownRolloutNode.Factory(new DistributionRollout4.Factory()),
					//						"/home/guy/Werk/thesis/weka-3-6-0/M5P-r-b.model",
					//						"/home/guy/Werk/thesis/weka-3-6-0/M5P-r-f.model",
					//						"/home/guy/Werk/thesis/weka-3-6-0/M5P-r-c.model",
					//						"/home/guy/Werk/thesis/weka-3-6-0/M5P-r-r.model"
					//				),

					//				new PrologCafeBotFactory(new ShowdownRolloutNode.Factory(new DistributionRollout4.Factory())),
					// new SearchBotFactory(new CachedShowdownNodeFactory(new
					// UniformShowdownNode.Factory())),
			});
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
	}

	public BotRunner(RemoteCSPokerServer cspokerServer, BotFactory[] bots) {
		try {
			this.botFactories = bots;
			nbPlayersPerGame = bots.length;//or a constant
			bot = new Bot[nbPlayersPerGame];
			botIndex = new int[nbPlayersPerGame];

			botLobbies = new SmartLobbyContext[bots.length];
			botIDs = new PlayerId[bots.length];

			SmartClientContext director = new SmartClientContext(cspokerServer
					.login("director", "test"));
			directorLobby = director.getLobbyContext(BotRunner.this);

			for (int i = 0; i < bots.length; i++) {
				SmartClientContext clientContext = new SmartClientContext(
						cspokerServer.login(bots[i].toString(), "test"));
				botLobbies[i] = clientContext
				.getLobbyContext(new DefaultLobbyListener());
				botIDs[i] = clientContext.getAccountContext().getPlayerID();
			}

			executor = SingleThreadRequestExecutor.getInstance();

			speedMonitor = new SpeedTestBotListener(reportInterval, this);
			csvLogger = new CSVLogListener(reportInterval,this);

			combinationgenerator = new CombinationGenerator(bots.length, nbPlayersPerGame);
			iterateBots();

		} catch (LoginException e) {
			throw new IllegalStateException("Login Failed", e);
		} catch (RemoteException e) {
			logger.error(e);
			throw new IllegalStateException("Server setup failed.", e);
		} catch (IllegalActionException e) {
			logger.error(e);
			throw new IllegalStateException("Server setup failed.", e);
		}

	}

	private void iterateBots() {
		if(combinationgenerator.hasMore()){
			botIndex = combinationgenerator.getNext();
			resetStateAndStartPlay();
		} else{
			shutdown();
		}
	}

	private void resetStateAndStartPlay() {
		gameLimiter = new GameLimitingBotListener(this, nbGamesPerConfrontation);
		speedMonitor = new SpeedTestBotListener(reportInterval, this);
		csvLogger = new CSVLogListener(reportInterval,this);
		playOnNewtable();
	}

	private void playOnNewtable() {
		try {
			String tableName = botFactories[botIndex[0]].toString();
			for (int i = 1; i < nbPlayersPerGame; i++) {
				tableName += " vs " + botFactories[botIndex[i]].toString();
			}
			TableId tableId = directorLobby.createHoldemTable(tableName, config).getId();
			int buyIn = nbBigBlindsBuyIn*config.getBigBlind();

			bot[0] = botFactories[botIndex[0]].createBot(botIDs[botIndex[0]], tableId,
					botLobbies[botIndex[0]], buyIn, executor,
					new ReSitInBotListener(this), csvLogger, speedMonitor, gameLimiter);
			bot[0].start();
			for (int i = 1; i < nbPlayersPerGame; i++) {
				bot[i] = botFactories[botIndex[i]].createBot(botIDs[botIndex[i]],
						tableId, botLobbies[botIndex[i]], buyIn, executor);
				bot[i].start();
			}
			bot[0].startGame();
		} catch (RemoteException e) {
			logger.error(e);
			throw new IllegalStateException("Server setup failed.", e);
		} catch (IllegalActionException e) {
			logger.error(e);
			throw new IllegalStateException("Server setup failed.", e);
		}
	}

	private void shutdown() {
		executor.shutdownNow();
		GlobalThreadPool.getInstance().shutdownNow();
	}

	public void onTableCreated(TableCreatedEvent tableCreatedEvent) {
		logger
		.debug(tableCreatedEvent.getTable().getName()
				+ " table created.");
	}

	public void onTableRemoved(TableRemovedEvent tableRemovedEvent) {
		logger.debug("Table " + tableRemovedEvent.getTableId() + " removed.");
	}

	public void respawnBots() {
		stopRunningBots();
		playOnNewtable();
	}

	private void stopRunningBots() {
		for (int i = 0; i < nbPlayersPerGame; i++) {
			bot[i].stop();
		}
	}

	public void moveToNextCombination() {
		stopRunningBots();
		iterateBots();
	}

	public BotFactory getBotFactory(int i) {
		return botFactories[botIndex[i]];
	}

	public Bot getBot(int i) {
		return bot[i];
	}

	public static TableConfiguration getConfig() {
		return config;
	}

}
