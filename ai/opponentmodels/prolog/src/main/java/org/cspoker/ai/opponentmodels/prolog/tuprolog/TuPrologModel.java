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
package org.cspoker.ai.opponentmodels.prolog.tuprolog;

import jp.ac.kobe_u.cs.prolog.builtin.PRED_assert_1;
import jp.ac.kobe_u.cs.prolog.builtin.PRED_prior_action_probability_6;
import jp.ac.kobe_u.cs.prolog.builtin.PRED_retract_1;
import jp.ac.kobe_u.cs.prolog.lang.IntegerTerm;
import jp.ac.kobe_u.cs.prolog.lang.SymbolTerm;
import jp.ac.kobe_u.cs.prolog.lang.VariableTerm;

import org.apache.log4j.Logger;
import org.cspoker.ai.bots.bot.gametree.mcts.nodes.INode;
import org.cspoker.ai.opponentmodels.prolog.AbstractPrologModel;
import org.cspoker.ai.opponentmodels.prolog.ToPrologTermVisitor;
import org.cspoker.common.elements.player.PlayerId;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.NoSolutionException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Term;
import alice.tuprolog.UnknownVarException;

public class TuPrologModel extends AbstractPrologModel {

	private final static Logger logger = Logger.getLogger(TuPrologModel.class);

	private final Prolog engine;

	public TuPrologModel(Prolog engine) {
		this.engine = engine;
	}

	@Override
	protected void assertTerm(jp.ac.kobe_u.cs.prolog.lang.StructureTerm term) {
		if (logger.isDebugEnabled()) {
			logger.debug("+" + term);
		}
		try {
			SolveInfo info = executeGoal(new PRED_assert_1(term, null) + ".");
			if (!info.isSuccess()) {
				throw new IllegalStateException("Failed to assert " + term);
			}
		} catch (MalformedGoalException e) {
			throw new IllegalStateException(e);
		}
	}

	private SolveInfo executeGoal(String goal) throws MalformedGoalException {
		long startTime = 0;
		boolean traceEnabled = logger.isTraceEnabled();
		if (traceEnabled) {
			startTime = System.nanoTime();
		}
		SolveInfo result = engine.solve(goal);
		if (traceEnabled) {
			logger.trace("Executing " + goal + " took "
					+ (System.nanoTime() - startTime) / 1000000.0 + " ms");

		}
		return result;
	}

	@Override
	protected void retractTerm(jp.ac.kobe_u.cs.prolog.lang.StructureTerm term) {
		if (logger.isDebugEnabled()) {
			logger.debug("-" + term);
		}
		try {
			SolveInfo info = executeGoal(new PRED_retract_1(term, null) + ".");
			if (!info.isSuccess()) {
				throw new IllegalStateException("Failed to assert " + term);
			}
		} catch (MalformedGoalException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	protected double priorActionProbability(SymbolTerm action, PlayerId playerId) {
		ToPrologTermVisitor visitor = getTopVisitor();
		IntegerTerm gameId = new IntegerTerm(visitor.getGameId());
		IntegerTerm actionId = new IntegerTerm(visitor.getActionId() + 1);
		SymbolTerm player = SymbolTerm.makeSymbol("player_" + playerId.getId());
		SymbolTerm round = visitor.getRound();
		VariableTerm p = new VariableTerm();
		PRED_prior_action_probability_6 pedicate = new PRED_prior_action_probability_6(
				gameId, actionId, player, action, round, p, null);
		String goal = pedicate.toString();
		goal = goal.replace(p.toString(), "P") + ".";
		if (logger.isDebugEnabled()) {
			logger.debug(goal);
		}
		SolveInfo info;
		try {
			info = executeGoal(goal);
		} catch (MalformedGoalException e) {
			throw new IllegalStateException(e);
		}
		if (!info.isSuccess()) {
			throw new IllegalStateException("Failed to call " + goal);
		}
		Term binding;
		try {
			binding = info.getTerm("P");
		} catch (NoSolutionException e) {
			throw new IllegalStateException("Failed to call " + goal, e);
		} catch (UnknownVarException e) {
			throw new IllegalStateException("Failed to call " + goal, e);
		}
		return ((alice.tuprolog.Number) binding).doubleValue();
	}

	@Override
	public void setChosenNode(INode node) {
		
	}

	@Override
	public INode getChosenNode() {
		return null;
	}

	@Override
	public PlayerId getBotId() {
		return null;
	}

}
