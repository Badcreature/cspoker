/**
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package org.cspoker.client.gui.swt.window;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.apache.log4j.Logger;
import org.cspoker.client.gui.swt.control.ClientGUI;
import org.cspoker.client.gui.swt.control.GameState;
import org.cspoker.client.gui.swt.control.SWTResourceManager;
import org.cspoker.client.gui.swt.control.UserSeatedPlayer;
import org.cspoker.common.api.lobby.holdemtable.event.*;
import org.cspoker.common.api.lobby.holdemtable.holdemplayer.event.NewPocketCardsEvent;
import org.cspoker.common.api.lobby.holdemtable.holdemplayer.listener.HoldemPlayerListener;
import org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener;
import org.cspoker.common.api.shared.exception.IllegalActionException;
import org.cspoker.common.elements.cards.Card;
import org.cspoker.common.elements.chips.IllegalValueException;
import org.cspoker.common.elements.chips.Pots;
import org.cspoker.common.elements.player.MutableSeatedPlayer;
import org.cspoker.common.elements.player.PlayerId;
import org.cspoker.common.elements.player.SeatedPlayer;
import org.cspoker.common.elements.table.DetailedHoldemTable;
import org.cspoker.common.elements.table.Rounds;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * A Game window for a particular table the user is sitting at. Events from the
 * server for the corresponding table are delivered here and handled/dispatched
 * go children controls such as {@link TableComposite} or
 * {@link PlayerSeatComposite}s
 * 
 * @author Stephan Schmidt
 */
public class GameWindow
		extends ClientComposite
		implements HoldemTableListener, HoldemPlayerListener {
	
	/** Minimum width so everything will still reasonably displayed */
	public static final int MINIMUM_WIDTH = 650;
	/** Minimum height so everything will still reasonably displayed */
	public static final int MINIMUM_HEIGHT = 650;
	
	private final static Logger logger = Logger.getLogger(GameWindow.class);
	private final UserSeatedPlayer user;
	private TableUserInputComposite userInputComposite;
	TableComposite tableComposite;
	
	/**
	 * Creates a new <code>GameWindow</code>.
	 * <p>
	 * Initializes the window and updates all the composites with the
	 * information passed in the {@link DetailedHoldemTable} information.
	 * 
	 * @param lobbyWindow The lobby reference
	 * @param table The table to display in the game window
	 */
	public GameWindow(LobbyWindow lobbyWindow, DetailedHoldemTable table) {
		super(new Shell(lobbyWindow.getDisplay(), SWT.CLOSE | SWT.RESIZE), SWT.NONE, lobbyWindow.getClientCore());
		gameState = new GameState(table);
		try {
			user = new UserSeatedPlayer(this, getClientCore(), gameState);
		} catch (IllegalValueException e) {
			throw new IllegalStateException(e);
		}
		user.joinTable(lobbyWindow.getContext());
		initGUI();
		for (SeatedPlayer player : table.getPlayers()) {
			MutableSeatedPlayer mutable = new MutableSeatedPlayer(player);
			tableComposite.findPlayerSeatCompositeBySeatId(player.getSeatId()).occupy(mutable);
		}
		// Initialize chat context
		user.getChatContext();
		userInputComposite.getGameInfoText().insert("Click on an open seat to join the game");
		
	}
	
	/**
	 * Does initial shell configuration
	 * 
	 * @param shell The GameWindow's shell to configure
	 */
	private void configureShell(final Shell shell) {
		// Get table info for display purposes
		shell.setText("Logged in as " + getClientCore().getUser().getUserName() + ", Table "
				+ gameState.getTableMemento().getName() + "(Id: " + gameState.getTableMemento().getId() + ")");
		shell.setImage(SWTResourceManager.getImage(ClientGUI.Resources.CS_POKER_ICON));
		shell.setLayout(new GridLayout());
		logger.debug("gw size: " + getSize());
		shell.setMinimumSize(MINIMUM_WIDTH, MINIMUM_HEIGHT);
		// TODO Somehow lock fixed x:y relation
		logger.debug("Shell size: " + shell.getSize());
		shell.addPaintListener(new PaintListener() {
			
			/**
			 * Make sure we handle the case when the shell is resized.
			 * <p>
			 * In this case, rescale the background image and recompute the
			 * areas where the chips are displayed on the table.
			 * 
			 * @see org.eclipse.swt.events.PaintListener#paintControl(org.eclipse.swt.events.PaintEvent)
			 */
			public void paintControl(PaintEvent e) {
				if (getBackgroundImage() != null) {
					getBackgroundImage().dispose();
				}
				Image skin = SWTResourceManager.getImage(ClientGUI.Resources.TABLE_IMAGE);
				Image scaled = new Image(Display.getDefault(), skin.getImageData().scaledTo(getShell().getSize().x,
						getShell().getSize().y));
				setBackgroundImage(scaled);
				tableComposite.updateTableGraphics();
				// logger.debug("TC: " + getTableComposite().getBounds());
				// logger.debug("PC: " +
				// getTableComposite().getPlayerSeatComposites(false).get(0).getBounds());
				// logger.debug("GW: " + getShell().getBounds());
			}
		});
		shell.addShellListener(new ShellAdapter() {
			
			/**
			 * @see org.eclipse.swt.events.ShellAdapter#shellClosed(org.eclipse.swt.events.ShellEvent)
			 */
			@Override
			public void shellClosed(ShellEvent e) {
				int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
				MessageBox messageBox = new MessageBox(getShell(), style);
				messageBox.setText("Leave table");
				messageBox.setMessage("Are you sure you want to leave this table?");
				e.doit = messageBox.open() == SWT.YES;
			}
		});
	}
	
	/**
	 * @param playerId
	 * @return
	 */
	private PlayerSeatComposite getPlayerSeatComposite(final PlayerId playerId) {
		return tableComposite.findPlayerSeatCompositeByPlayerId(playerId);
	}
	
	private void initGUI() {
		
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		data.minimumWidth = 500;
		data.minimumHeight = 450;
		setLayout(new GridLayout(1, true));
		setLayoutData(data);
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		tableComposite = new TableComposite(this, SWT.NONE | ClientGUI.COMPOSITE_BORDER_STYLE);
		userInputComposite = new TableUserInputComposite(this, SWT.NONE | ClientGUI.COMPOSITE_BORDER_STYLE);
		configureShell(getShell());
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onBet(org.cspoker.common.api.lobby.holdemtable.event.BetEvent)
	 */
	public void onBet(BetEvent betEvent) {
		handleActionChangedPot(betEvent.getAmount(), betEvent.getPlayerId(), "Bet");
		userInputComposite.showDealerMessage(betEvent);
	}
	
	private void handleActionChangedPot(int amount, PlayerId playerId, String action) {
		// Update the chip stack of the player who changed the pot by
		// betting/raising/calling
		MutableSeatedPlayer player = getPlayerSeatComposite(playerId).getPlayer();
		gameState.updateStackAndBetChips(player, amount);
		gameState.betRaise(amount);
		gameState.getBetPile(player).clear();
		gameState.getBetPile(player).addAll(gameState.getCurrentBetPile());
		// Game State update
		// Set new reference bet pile in GameState
		
		getPlayerSeatComposite(playerId).showAction(action);
		
		ClientGUI.playAudio(ClientGUI.Resources.SOUND_FILE_BETRAISE);
		tableComposite.updateTableGraphics();
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onBigBlind(org.cspoker.common.api.lobby.holdemtable.event.BigBlindEvent)
	 */
	public void onBigBlind(final BigBlindEvent event) {
		// Special case: clear bet pile so we draw big blind in one stack
		gameState.getCurrentBetPile().clear();
		handleActionChangedPot(event.getAmount(), event.getPlayerId(), "Big Blind");
		userInputComposite.showDealerMessage(event);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onCall(org.cspoker.common.api.lobby.holdemtable.event.CallEvent)
	 */
	public void onCall(CallEvent callEvent) {
		handleActionChangedPot(0, callEvent.getPlayerId(), "Call");
		userInputComposite.showDealerMessage(callEvent);
		
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onCheck(org.cspoker.common.api.lobby.holdemtable.event.CheckEvent)
	 */
	public void onCheck(CheckEvent checkEvent) {
		getPlayerSeatComposite(checkEvent.getPlayerId()).showAction("Check");
		userInputComposite.showDealerMessage(checkEvent);
		
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onFold(org.cspoker.common.api.lobby.holdemtable.event.FoldEvent)
	 */
	public void onFold(FoldEvent foldEvent) {
		getPlayerSeatComposite(foldEvent.getPlayerId()).showAction("Fold");
		Collection<Card> noCards = Collections.emptySet();
		getPlayerSeatComposite(foldEvent.getPlayerId()).setHoleCards(noCards);
		userInputComposite.showDealerMessage(foldEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onLeaveGame(org.cspoker.common.api.lobby.holdemtable.event.LeaveGameEvent)
	 */
	public void onSitOut(SitOutEvent sitOutEvent) {
		PlayerSeatComposite psc = getPlayerSeatComposite(sitOutEvent.getPlayerId());
		psc.getPlayer().setSittingIn(false);
		
		psc.updatePlayerInfo();
		if (sitOutEvent.getPlayerId().equals(user.getMemento().getId())) {
			if (!userInputComposite.sitInOutButton.isFocusControl()) {
				userInputComposite.sitInOutButton.setText("Sit In");
				userInputComposite.sitInOutButton.setSelection(false);
			}
		}
		
		userInputComposite.showDealerMessage(sitOutEvent);
		tableComposite.updateTableGraphics();
		
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onNewCommunityCards(org.cspoker.common.api.lobby.holdemtable.event.NewCommunityCardsEvent)
	 */
	public void onNewCommunityCards(NewCommunityCardsEvent newCommunityCardsEvent) {
		tableComposite.addCommunityCards(newCommunityCardsEvent.getCommunityCards());
		userInputComposite.showDealerMessage(newCommunityCardsEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onNewDeal(org.cspoker.common.api.lobby.holdemtable.event.NewDealEvent)
	 */
	public void onNewDeal(NewDealEvent newDealEvent) {
		logger.debug("New deal event received");
		gameState.newRound();
		gameState.setPots(new Pots(0));
		PlayerSeatComposite newDealer = tableComposite.findPlayerSeatCompositeByPlayerId(newDealEvent.getDealer());
		for (PlayerSeatComposite psc : tableComposite.getPlayerSeatComposites(true)) {
			if (psc.getPlayer().equals(gameState.getDealer())) {
				tableComposite.moveDealerButton(psc, newDealer);
				gameState.setDealer(newDealer.getPlayer());
			}
			
			psc.setHoleCards(Arrays.asList(ClientGUI.UNKNOWN_CARD, ClientGUI.UNKNOWN_CARD));
			psc.getPlayer().getBetChips().discard();
			gameState.getBetPile(psc.getPlayer()).clear();
		}
		
		userInputComposite.showDealerMessage(newDealEvent);
		tableComposite.redraw();
		logger.debug("New deal event handled");
		
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.holdemplayer.listener.HoldemPlayerListener#onNewPocketCards(org.cspoker.common.api.lobby.holdemtable.holdemplayer.event.NewPocketCardsEvent)
	 */
	public void onNewPocketCards(NewPocketCardsEvent newPocketCardsEvent) {
		getPlayerSeatComposite(user.getId()).setHoleCards(newPocketCardsEvent.getPocketCards());
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onNewRound(org.cspoker.common.api.lobby.holdemtable.event.NewRoundEvent)
	 */
	public void onNewRound(NewRoundEvent newRoundEvent) {
		if (newRoundEvent.getRound() != Rounds.PREFLOP) {
			tableComposite.moveBetsToPot();
		}
		gameState.newRound();
		tableComposite.updateTableGraphics();
		userInputComposite.showDealerMessage(newRoundEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onNextPlayer(org.cspoker.common.api.lobby.holdemtable.event.NextPlayerEvent)
	 */
	public void onNextPlayer(NextPlayerEvent nextPlayerEvent) {
		PlayerId playerToAct = nextPlayerEvent.getPlayerId();
		tableComposite.proceedToNextPlayer(playerToAct);
		userInputComposite.getGameActionGroup().setVisible(user.getMemento().getId().equals(playerToAct));
		if (user.getMemento().getId().equals(playerToAct)) {
			userInputComposite.prepareForUserInput();
		}
		userInputComposite.update();
		
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onRaise(org.cspoker.common.api.lobby.holdemtable.event.RaiseEvent)
	 */
	public void onRaise(RaiseEvent raiseEvent) {
		handleActionChangedPot(raiseEvent.getAmount(), raiseEvent.getPlayerId(), "Raise");
		userInputComposite.showDealerMessage(raiseEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onShowHand(org.cspoker.common.api.lobby.holdemtable.event.ShowHandEvent)
	 */
	public void onShowHand(ShowHandEvent showHandEvent) {
		getPlayerSeatComposite(showHandEvent.getShowdownPlayer().getId()).setHoleCards(
				showHandEvent.getShowdownPlayer().getHandCards());
		// userInputComposite.showDealerMessage(showHandEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onSitIn(org.cspoker.common.api.lobby.holdemtable.event.SitInEvent)
	 */
	public void onSitIn(SitInEvent sitInEvent) {
		MutableSeatedPlayer player = new MutableSeatedPlayer(sitInEvent.getPlayer());
		
		if (user.getId().equals(sitInEvent.getPlayer().getId())) {
			user.update(sitInEvent.getPlayer());
			userInputComposite.generalActionHolder.setVisible(true);
			userInputComposite.sitInOutButton.setText("Sit Out");
			userInputComposite.sitInOutButton.setSelection(true);
			player = user;
		}
		tableComposite.findPlayerSeatCompositeBySeatId(sitInEvent.getPlayer().getSeatId()).occupy(player);
		userInputComposite.showDealerMessage(sitInEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onSmallBlind(org.cspoker.common.api.lobby.holdemtable.event.SmallBlindEvent)
	 */
	public void onSmallBlind(SmallBlindEvent smallBlindEvent) {
		handleActionChangedPot(smallBlindEvent.getAmount(), smallBlindEvent.getPlayerId(), "Small Blind");
		userInputComposite.showDealerMessage(smallBlindEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onWinner(org.cspoker.common.api.lobby.holdemtable.event.WinnerEvent)
	 */
	public void onWinner(final WinnerEvent winnerEvent) {
		tableComposite.moveBetsToPot();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.warn("Sleep interrupted", e);
			Thread.currentThread().interrupt();
		}
		tableComposite.movePotsToWinners(winnerEvent.getWinners());
		
		tableComposite.clearCommunityCards();
		tableComposite.getCommunityCardsComposite().setVisible(false);
		for (PlayerSeatComposite psc : tableComposite.getPlayerSeatComposites(true)) {
			Set<Card> noCards = Collections.emptySet();
			psc.setHoleCards(noCards);
			psc.setActive(false);
			psc.updatePlayerInfo();
		}
		userInputComposite.showDealerMessage(winnerEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onAllIn(org.cspoker.common.api.lobby.holdemtable.event.AllInEvent)
	 */
	@Override
	public void onAllIn(AllInEvent allInEvent) {
		userInputComposite.showDealerMessage(allInEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onJoinTable(org.cspoker.common.api.lobby.holdemtable.event.JoinTableEvent)
	 */
	@Override
	public void onJoinTable(JoinTableEvent joinTableEvent) {
		userInputComposite.showDealerMessage(joinTableEvent);
	}
	
	/**
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onLeaveTable(org.cspoker.common.api.lobby.holdemtable.event.LeaveTableEvent)
	 */
	@Override
	public void onLeaveTable(LeaveTableEvent leaveGameEvent) {
		userInputComposite.showDealerMessage(leaveGameEvent);
	}
	
	/**
	 * y
	 * 
	 * @see org.cspoker.common.api.lobby.holdemtable.listener.HoldemTableListener#onPotsChanged(org.cspoker.common.api.lobby.holdemtable.event.PotsChangedEvent)
	 */
	@Override
	public void onPotsChanged(PotsChangedEvent potsChangedEvent) {
		gameState.setPots(potsChangedEvent.getPots());
		userInputComposite.showDealerMessage(potsChangedEvent);
	}
	
	/**
	 * PRE: Window is initialized Open the window in a new shell Open the
	 * GameWindow inside a new shell
	 */
	public void show() {
		Shell containingShell = getShell();
		containingShell.open();
		Display display = containingShell.getDisplay();
		// Listen to events
		while (!containingShell.isDisposed() && !display.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		// Finally leave table
		logger.info("Leaving table");
		try {
			user.getTableContext().leaveTable();
			getClientCore().getGui().getGameWindows().remove(this);
		} catch (RemoteException e1) {
			getClientCore().handleRemoteException(e1);
		} catch (IllegalActionException e1) {
			logger.error("This should not happen", e1);
		}
	}
	
	/**
	 * @return The {@link LobbyWindow} (Parent of all GameWindows)
	 * @see org.eclipse.swt.widgets.Control#getParent()
	 */
	@Override
	public LobbyWindow getParent() {
		return (LobbyWindow) super.getParent();
	}
	
	/**
	 * @return The contained {@link TableUserInputComposite}
	 */
	public TableUserInputComposite getUserInputComposite() {
		return userInputComposite;
	}
	
	/**
	 * @return The contained {@link TableComposite}
	 */
	public TableComposite getTableComposite() {
		return tableComposite;
	}
	
	/**
	 * @return This GameWindow's user. The user is the access point for all
	 *         callbacks to the Server!
	 */
	public UserSeatedPlayer getUser() {
		return user;
	}
}
