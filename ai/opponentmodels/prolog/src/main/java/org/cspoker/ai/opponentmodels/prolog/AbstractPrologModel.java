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
package org.cspoker.ai.opponentmodels.prolog;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import jp.ac.kobe_u.cs.prolog.lang.StructureTerm;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;

import org.apache.log4j.Logger;
import org.cspoker.ai.opponentmodels.OpponentModel;
import org.cspoker.client.common.gamestate.GameState;
import org.cspoker.common.elements.player.PlayerId;
import org.cspoker.common.util.Pair;
import org.cspoker.common.util.Triple;

public abstract class AbstractPrologModel implements OpponentModel {

	private final static Logger logger = Logger
			.getLogger(AbstractPrologModel.class);

	public final static SymbolTerm fold = SymbolTerm.makeSymbol("fold");
	public final static SymbolTerm call = SymbolTerm.makeSymbol("call");
	public final static SymbolTerm check = SymbolTerm.makeSymbol("check");
	public final static SymbolTerm bet = SymbolTerm.makeSymbol("bet");
	public final static SymbolTerm raise = SymbolTerm.makeSymbol("bet");

	private final ToPrologTermVisitor assertingVisitor;

	private final Deque<TermListVisitor> visitors = new ArrayDeque<TermListVisitor>();

	public AbstractPrologModel() {
		assertingVisitor = new ToPrologTermVisitor() {
			@Override
			protected void addTerm(StructureTerm term) {
				assertTerm(term);
			}
		};
	}

	protected abstract void assertTerm(
			jp.ac.kobe_u.cs.prolog.lang.StructureTerm term);

	protected abstract void retractTerm(
			jp.ac.kobe_u.cs.prolog.lang.StructureTerm term);

	protected abstract double priorActionProbability(SymbolTerm action,
			PlayerId playerId);

	@Override
	public Pair<Double, Double> getCheckBetProbabilities(GameState gameState,
			PlayerId actor) {
		return new Pair<Double, Double>(priorActionProbability(check, actor),
				priorActionProbability(bet, actor));
	}

	@Override
	public Triple<Double, Double, Double> getFoldCallRaiseProbabilities(
			GameState gameState, PlayerId actor) {
		return new Triple<Double, Double, Double>(priorActionProbability(fold,
				actor), priorActionProbability(call, actor),
				priorActionProbability(raise, actor));
	}

	@Override
	public double[] getShowdownProbabilities(GameState gameState,PlayerId actor)
			throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void assumePermanently(GameState gameState) {
		if (logger.isDebugEnabled()) {
			logger.debug("Signalling " + gameState);
		}
		assertingVisitor.readHistory(gameState);
	}

	@Override
	public void assumeTemporarily(GameState gameState) {
		if (logger.isDebugEnabled()) {
			logger.debug("Assuming " + gameState);
		}
		LoggingVisitor root = getTopVisitor();
		TermListVisitor visitor = new TermListVisitor(root);
		visitor.readHistory(gameState);
		List<jp.ac.kobe_u.cs.prolog.lang.StructureTerm> terms = visitor
				.getTerms();
		for (jp.ac.kobe_u.cs.prolog.lang.StructureTerm term : terms) {
			assertTerm(term);
		}
		visitors.push(visitor);
	}

	@Override
	public void forgetLastAssumption() {
		TermListVisitor visitor = visitors.pop();
		if (logger.isDebugEnabled()) {
			logger.debug("Forgetting " + visitor);
		}
		List<jp.ac.kobe_u.cs.prolog.lang.StructureTerm> terms = visitor
				.getTerms();
		for (int i = terms.size() - 1; i >= 0; i--) {
			retractTerm(terms.get(i));
		}
	}
	

	protected ToPrologTermVisitor getTopVisitor() {
		return visitors.isEmpty() ? assertingVisitor : visitors.peek();
	}
}
