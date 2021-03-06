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
package org.cspoker.external.pokersource.eventlisteners.all;

import org.cspoker.external.pokersource.commands.poker.Call;
import org.cspoker.external.pokersource.commands.poker.Check;
import org.cspoker.external.pokersource.commands.poker.Fold;
import org.cspoker.external.pokersource.commands.poker.Raise;
import org.cspoker.external.pokersource.commands.poker.Sit;
import org.cspoker.external.pokersource.commands.poker.SitOut;
import org.cspoker.external.pokersource.events.AuthOk;
import org.cspoker.external.pokersource.events.AuthRefused;
import org.cspoker.external.pokersource.events.Error;
import org.cspoker.external.pokersource.events.Serial;
import org.cspoker.external.pokersource.events.poker.AllinShowdown;
import org.cspoker.external.pokersource.events.poker.AutoBlindAnte;
import org.cspoker.external.pokersource.events.poker.AutoFold;
import org.cspoker.external.pokersource.events.poker.BatchMode;
import org.cspoker.external.pokersource.events.poker.BeginRound;
import org.cspoker.external.pokersource.events.poker.BestCards;
import org.cspoker.external.pokersource.events.poker.BetLimit;
import org.cspoker.external.pokersource.events.poker.Blind;
import org.cspoker.external.pokersource.events.poker.BoardCards;
import org.cspoker.external.pokersource.events.poker.BuyInLimits;
import org.cspoker.external.pokersource.events.poker.Chat;
import org.cspoker.external.pokersource.events.poker.ChipsBet2Pot;
import org.cspoker.external.pokersource.events.poker.ChipsPlayer2Bet;
import org.cspoker.external.pokersource.events.poker.ChipsPot2Player;
import org.cspoker.external.pokersource.events.poker.ChipsPotMerge;
import org.cspoker.external.pokersource.events.poker.ChipsPotReset;
import org.cspoker.external.pokersource.events.poker.DealCards;
import org.cspoker.external.pokersource.events.poker.Dealer;
import org.cspoker.external.pokersource.events.poker.EndRound;
import org.cspoker.external.pokersource.events.poker.EndRoundLast;
import org.cspoker.external.pokersource.events.poker.HighestBetIncrease;
import org.cspoker.external.pokersource.events.poker.InGame;
import org.cspoker.external.pokersource.events.poker.PlayerArrive;
import org.cspoker.external.pokersource.events.poker.PlayerCards;
import org.cspoker.external.pokersource.events.poker.PlayerChips;
import org.cspoker.external.pokersource.events.poker.PlayerHandStrength;
import org.cspoker.external.pokersource.events.poker.PlayerInfo;
import org.cspoker.external.pokersource.events.poker.PlayerLeave;
import org.cspoker.external.pokersource.events.poker.PlayerStats;
import org.cspoker.external.pokersource.events.poker.PlayerWin;
import org.cspoker.external.pokersource.events.poker.Position;
import org.cspoker.external.pokersource.events.poker.PotChips;
import org.cspoker.external.pokersource.events.poker.Rake;
import org.cspoker.external.pokersource.events.poker.Seat;
import org.cspoker.external.pokersource.events.poker.Seats;
import org.cspoker.external.pokersource.events.poker.SelfInPosition;
import org.cspoker.external.pokersource.events.poker.SelfLostPosition;
import org.cspoker.external.pokersource.events.poker.Showdown;
import org.cspoker.external.pokersource.events.poker.Start;
import org.cspoker.external.pokersource.events.poker.State;
import org.cspoker.external.pokersource.events.poker.StreamMode;
import org.cspoker.external.pokersource.events.poker.Table;
import org.cspoker.external.pokersource.events.poker.TimeoutWarning;
import org.cspoker.external.pokersource.events.poker.UserInfo;
import org.cspoker.external.pokersource.events.poker.WaitFor;
import org.cspoker.external.pokersource.events.poker.Win;
import org.cspoker.external.pokersource.events.poker.client.ClientPlayerChips;
import org.cspoker.external.pokersource.events.poker.client.CurrentGames;

public class DefaultListener implements AllEventListener{

	@Override
	public void onAuthOk(AuthOk authOk) {
	}

	@Override
	public void onSerial(Serial serial) {
	}
	
	@Override
	public void onPlayerInfo(PlayerInfo playerInfo) {
	}
	
	@Override
	public void onTable(Table table) {
	}
	
	@Override
	public void onCurrentGames(CurrentGames currentGames) {
	}
	
	@Override
	public void onBuyInLimits(BuyInLimits buyInLimits) {
	}
	
	@Override
	public void onBatchMode(BatchMode batchMode) {
	}

	@Override
	public void onPlayerLeave(PlayerLeave playerLeave) {
	}
	
	@Override
	public void onPlayerArrive(PlayerArrive playerArrive) {
	}
	
	@Override
	public void onSeats(Seats seats) {
	}
	
	@Override
	public void onPlayerStats(PlayerStats playerStats) {
	}
	
	@Override
	public void onPlayerChips(PlayerChips playerChips) {
	}
	
	@Override
	public void onClientPlayerChips(ClientPlayerChips clientPlayerChips) {
	}
	
	@Override
	public void onSit(Sit sit) {
	}
	
	@Override
	public void onStreamMode(StreamMode streamMode) {
	}
	
	@Override
	public void onUserInfo(UserInfo userInfo) {
	}
	
	@Override
	public void onAutoBlindAnte(AutoBlindAnte autoBlindAnte) {
	}
	
	@Override
	public void onSeat(Seat seat) {
	}
	
	@Override
	public void onAutoFold(AutoFold autoFold) {
	}
	
	@Override
	public void onSitOut(SitOut sitOut) {
	}
	
	@Override
	public void onInGame(InGame inGame) {
	}
	
	@Override
	public void onDealer(Dealer dealer) {
	}
	
	@Override
	public void onFold(Fold fold) {
	}
	
	@Override
	public void onStart(Start start) {
	}
	
	@Override
	public void onPosition(Position position) {
	}
	
	@Override
	public void onBoardCards(BoardCards boardCards) {
	}
	
	@Override
	public void onSelfLostPosition(SelfLostPosition selfLostPosition) {
	}
	
	@Override
	public void onChipsPotReset(ChipsPotReset chipsPotReset) {
	}
	
	@Override
	public void onBlind(Blind blind) {
	}
	
	@Override
	public void onChat(Chat chat) {
	}
	
	@Override
	public void onChipsPlayer2Bet(ChipsPlayer2Bet chipsPlayer2Bet) {
	}
	
	@Override
	public void onWaitFor(WaitFor waitFor) {
	}
	
	@Override
	public void onPlayerCards(PlayerCards playerCards) {
	}
	
	@Override
	public void onState(State state) {
	}
	
	@Override
	public void onDealCards(DealCards dealCards) {
	}
	
	@Override
	public void onBetLimit(BetLimit betLimit) {
	}
	
	@Override
	public void onBeginRound(BeginRound beginRound) {
	}
	
	@Override
	public void onCall(Call call) {
	}
	
	@Override
	public void onSelfInPosition(SelfInPosition selfInPosition) {
	}
	
	@Override
	public void onEndRound(EndRound endRound) {
	}
	
	@Override
	public void onRaise(Raise raise) {
	}
	
	@Override
	public void onChipsBet2Pot(ChipsBet2Pot chipsBet2Pot) {
	}
	
	@Override
	public void onCheck(Check check) {
	}
	
	@Override
	public void onPotChips(PotChips potChips) {
	}
	
	@Override
	public void onPlayerHandStrength(PlayerHandStrength playerHandStrength) {
	}
	
	@Override
	public void onHighestBetIncrease(HighestBetIncrease highestBetIncrease) {
	}
	
	@Override
	public void onRake(Rake rake) {
	}
	
	@Override
	public void onAllinShowdown(AllinShowdown allinShowdown) {
	}
	
	@Override
	public void onEndRoundLast(EndRoundLast endRoundLast) {
	}
	
	@Override
	public void onWin(Win win) {
	}
	
	@Override
	public void onPlayerWin(PlayerWin playerWin) {
	}
	
	@Override
	public void onBestCards(BestCards bestCards) {
	}
	
	@Override
	public void onShowdown(Showdown showdown) {
	}
	
	@Override
	public void onChipsPot2Player(ChipsPot2Player chipsPot2Player) {
	}
	
	@Override
	public void onChipsPotMerge(ChipsPotMerge chipsPotMere) {
	}
	
	@Override
	public void onTimeoutWarning(TimeoutWarning timeoutWarning) {
	}
	
	@Override
	public void onAuthRefused(AuthRefused authRefused) {
	}
	
	@Override
	public void onError(Error error) {
	}
	
}
