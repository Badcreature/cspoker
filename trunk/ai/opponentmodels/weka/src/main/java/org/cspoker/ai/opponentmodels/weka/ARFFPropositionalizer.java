package org.cspoker.ai.opponentmodels.weka;

import java.io.IOException;
import java.util.HashMap;

//import org.apache.log4j.Logger;
import org.cspoker.ai.opponentmodels.weka.instances.InstancesBuilder;
import org.cspoker.ai.opponentmodels.weka.instances.PostCheckBetInstances;
import org.cspoker.ai.opponentmodels.weka.instances.PostFoldCallRaiseInstances;
import org.cspoker.ai.opponentmodels.weka.instances.PreCheckBetInstances;
import org.cspoker.ai.opponentmodels.weka.instances.PreFoldCallRaiseInstances;
import org.cspoker.ai.opponentmodels.weka.instances.ShowdownInstances;
import org.cspoker.common.elements.cards.Card;

public class ARFFPropositionalizer extends Propositionalizer {

//	private final static Logger logger = Logger.getLogger(ARFFPropositionalizer.class);
	
	private static final String nl = InstancesBuilder.nl;	
	
	private final HashMap<String, Card> cards = new HashMap<String, Card>();
	private HashMap<Object, ARFFFile> arffFiles = new HashMap<Object, ARFFFile>();
	
	private final PreCheckBetInstances preCheckBetInstance;
	private final PostCheckBetInstances postCheckBetInstance;
	private final PreFoldCallRaiseInstances preFoldCallRaiseInstance;
	private final PostFoldCallRaiseInstances postFoldCallRaiseInstance;
	private final ShowdownInstances showdownInstance;
	
	private boolean newDeal = false;
	private boolean overwrite;
	
	public ARFFPropositionalizer(boolean overwrite) throws IOException {
		this.overwrite = overwrite;
		this.preCheckBetInstance = getPreCheckBetInstance();
		this.postCheckBetInstance = getPostCheckBetInstance();
		this.preFoldCallRaiseInstance = getPreFoldCallRaiseInstance();
		this.postFoldCallRaiseInstance = getPostFoldCallRaiseInstance();
		this.showdownInstance = getShowdownInstance();

		for(Card c:Card.values()){
			cards.put(c.getShortDescription(), c);
		}
	}
	
	@Override
	public ARFFPropositionalizer clone() {
		ARFFPropositionalizer clone = (ARFFPropositionalizer)super.clone();
		clone.arffFiles = new HashMap<Object, ARFFFile>(arffFiles);
		return clone;
	}
	
	public static PreCheckBetInstances getPreCheckBetInstance() {
		return new PreCheckBetInstances("PreCheckBet",
				"@attribute betProb real" + nl
						+ "@attribute action {check, bet}" + nl);
	}
	
	public static PostCheckBetInstances getPostCheckBetInstance() {
		return new PostCheckBetInstances("PostCheckBet",
				"@attribute betProb real" + nl
				+ "@attribute action {check, bet}" + nl);
	}
	
	public static PreFoldCallRaiseInstances getPreFoldCallRaiseInstance() {
		return new PreFoldCallRaiseInstances(
				"PreFoldCallRaise", "@attribute foldProb real" + nl
				+ "@attribute callProb real" + nl
				+ "@attribute raiseProb real" + nl
				+ "@attribute action {fold,call,raise}" + nl);
	}
	
	public static PostFoldCallRaiseInstances getPostFoldCallRaiseInstance() {
		return new PostFoldCallRaiseInstances(
				"PostFoldCallRaise", "@attribute foldProb real" + nl
				+ "@attribute callProb real" + nl
				+ "@attribute raiseProb real" + nl
				+ "@attribute action {fold,call,raise}" + nl);
	}
	
	public static ShowdownInstances getShowdownInstance() {
		return new ShowdownInstances("Showdown",
				"@attribute part0Prob real" + nl + "@attribute part1Prob real"
				+ nl + "@attribute part2Prob real" + nl
				+ "@attribute part3Prob real" + nl
				+ "@attribute part4Prob real" + nl
				+ "@attribute part5Prob real" + nl
				+ "@attribute avgPartition {0,1,2,3,4,5}" + nl);
	}
	
	private ARFFFile getARFF(Object actorId) {
		if (arffFiles.containsKey(actorId))
			return arffFiles.get(actorId);
		else {
			try {
				ARFFFile f = new ARFFFile(actorId, overwrite);
				arffFiles.put(actorId, f);
				return f;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void setNewDeal(boolean deal) {
		newDeal = deal;
	}
	
	public boolean isNewDeal() {
		return newDeal;
	}
	
	@Override
	protected void logFold(Object actorId) {
		if (!newDeal) return;
		if (getRound().equals("preflop")) {
			getARFF(actorId).writePreFoldCallRaise(
					preFoldCallRaiseInstance.getClassifiedInstance(this,
							actorId, new Object[] { 1, 0, 0, "fold" }));
		} else {
			getARFF(actorId).writePostFoldCallRaise(
					postFoldCallRaiseInstance.getClassifiedInstance(this,
							actorId, new Object[] { 1, 0, 0, "fold" }));
		}
	}


	@Override
	protected void logCall(Object actorId) {
		if (!newDeal) return;
		if (getRound().equals("preflop")) {
			getARFF(actorId).writePreFoldCallRaise(
					preFoldCallRaiseInstance.getClassifiedInstance(this,
							actorId, new Object[] { 0, 1, 0, "call" }));
		} else {
			getARFF(actorId).writePostFoldCallRaise(
					postFoldCallRaiseInstance.getClassifiedInstance(this,
							actorId, new Object[] { 0, 1, 0, "call" }));
		}
	}

	@Override
	protected void logRaise(Object actorId, double raiseAmount) {
		if (!newDeal) return;
		if (getRound().equals("preflop")) {
			getARFF(actorId).writePreFoldCallRaise(
					preFoldCallRaiseInstance.getClassifiedInstance(this,
							actorId, new Object[] { 0, 0, 1, "raise" }));
		} else {
			getARFF(actorId).writePostFoldCallRaise(
					postFoldCallRaiseInstance.getClassifiedInstance(this,
							actorId, new Object[] { 0, 0, 1, "raise" }));
		}
	}

	@Override
	protected void logCheck(Object actorId) {
		if (!newDeal) return;
		if (getRound().equals("preflop")) {
			getARFF(actorId).writePreCheckBet(
					preCheckBetInstance.getClassifiedInstance(this, actorId,
							new Object[] { 0, "check" }));
		} else {
			getARFF(actorId).writePostCheckBet(
					postCheckBetInstance.getClassifiedInstance(this, actorId,
							new Object[] { 0, "check" }));
		}
	}

	@Override
	protected void logBet(Object actorId, double raiseAmount) {
		if (!newDeal) return;
		if (getRound().equals("preflop")) {
			getARFF(actorId).writePreCheckBet(
					preCheckBetInstance.getClassifiedInstance(this, actorId,
							new Object[] { 1, "bet" }));
		} else {
			getARFF(actorId).writePostCheckBet(
					postCheckBetInstance.getClassifiedInstance(this, actorId,
							new Object[] { 1, "bet" }));
		}
	}

	@Override
	protected void logShowdown(Object actorId, double[] partitionDistr) {
		if (!newDeal) return;
		Object[] targets = new Object[partitionDistr.length + 1];
		double avgBucket = 0;
		for (int i = 0; i < partitionDistr.length; i++) {
			targets[i] = partitionDistr[i];
			avgBucket += i * partitionDistr[i];
		}
		targets[partitionDistr.length] = (int) Math.round(avgBucket);
		getARFF(actorId).writeShowdown(
				showdownInstance.getClassifiedInstance(this, actorId, targets));
	}
}
