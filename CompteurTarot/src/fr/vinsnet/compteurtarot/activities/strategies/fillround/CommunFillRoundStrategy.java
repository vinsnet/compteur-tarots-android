/*******************************************************************************
 * Copyright (c) 2012 vinsnet<vinsnet@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     vinsnet<vinsnet@gmail.com> - initial API and implementation
 ******************************************************************************/
package fr.vinsnet.compteurtarot.activities.strategies.fillround;

import java.util.List;

import fr.vinsnet.compteurtarot.activities.strategies.calcutateresult.ResultStrategy;
import fr.vinsnet.compteurtarot.model.Bid;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.PetitAuBout;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Poignee;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.compteurtarot.model.strategies.RoundResult;

public abstract class CommunFillRoundStrategy implements FillRoundStrategy {
	private Game game;
	private FillRoundStrategy.Actionable actionable;
	private ResultStrategy resultStrategy;
	private Round currentRound;

	public FillRoundStrategy.Actionable getActionable() {
		return actionable;
	}

	public CommunFillRoundStrategy(Game game,Round currentRound,FillRoundStrategy.Actionable actionable) {
		this.game=game;
		this.actionable = actionable;
		this.currentRound = currentRound;
		resultStrategy = game.getNewResultStrategy(getCurrentRound());
	}
	
	public void setActionable(FillRoundStrategy.Actionable actionable){
		this.actionable = actionable;
	}
	
	public void setBidding(Bid bidding) {
		getCurrentRound().setbidding(bidding);
		biddindSelected();
	}

	public Round getCurrentRound() {
		return this.currentRound;
	}

	protected void biddindSelected(){
		actionable.onBiddingSelected();
	}
	
	public void chooseTakers(){
		getCurrentRound().clearTeams();
		askTaker();
		
	}
	public void setPetitAuBout(PetitAuBout pab) {
		getCurrentRound().setPetitAuBout(pab);
		petitAuBoutUpdated();
		
	}
	
	private void petitAuBoutUpdated() {
		actionable.onPetitAuBoutUpdated();
		
	}

	protected void askTaker() {
		actionable.onAskTaker(getGame().getPlayers());
	}

	protected void chooseDefenders() {
		Round currentRount = getCurrentRound();
		
		List<Player> defenders = currentRount.getDefenders();
		List<Player> takers = currentRount.getTakers();
		
		
		for(Player p:getGame().getPlayers()){
			boolean currentIsTaker=false;
			for(Player t:takers){
				if(p.getId()==t.getId()){
					currentIsTaker=true;
				}
			}
			if(!currentIsTaker){
				defenders.add(p);
			}
		}
		
		teamCompleted();
		
	}

	protected void teamCompleted() {

		getActionable().onTeamsCompleted();
		
	}
	
	public void setScoreTakers(float score){
		getCurrentRound().setScoreTakers(score);
		scoreUpdated();
	}

	private void scoreUpdated() {
		actionable.onScoreUpdated();
		
	}

	public void setNbBoutsTakers(int nbBouts){
		getCurrentRound().setNbBoutsTakers(nbBouts);
		nbBoutsSet();
	}
	
	protected void nbBoutsSet(){
		actionable.onNbBoutsSet();
	}
	
	public Game getGame() {
		return game;
	}
	

public boolean isTeamCompleted() {
return getCurrentRound().getDefenders().size()!=0;
}
	
	public RoundResult getResult() {
		return resultStrategy.getResult();
	}
	
	public boolean isResultAvaible() {
		return resultStrategy.isResultAvaible();
	}
	
	public void addBonus(Bonus b) {
		getCurrentRound().getBonus().add(b);
		bonusUpdated();
	}

	protected void bonusUpdated() {
		actionable.onBonusUpdated();
		
	}
	
	public void  addPoignee(Poignee p){
		getCurrentRound().getPoignees().add(p);
		poigneesUpdated();
	}

	private void poigneesUpdated() {
		actionable.onPoigneesUpdated();
		
	}
	

	
}
