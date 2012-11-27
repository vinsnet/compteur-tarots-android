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

import fr.vinsnet.compteurtarot.model.Bid;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.PetitAuBout;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Poignee;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.compteurtarot.model.strategies.RoundResult;

public interface FillRoundStrategy {

	public void setActionable(FillRoundStrategy.Actionable actionable);

	public void setBidding(Bid bidding);

	public void addTaker(Player p);
	
	public void chooseTakers();
	
	public Game getGame();
	
	public Round getCurrentRound();

	public void setNbBoutsTakers(int progress);

	public void setScoreTakers(float score);
	
	public int getScoreIntervalDivider();
	
	public RoundResult getResult();

	public boolean isResultAvaible();

	public boolean isTeamCompleted();

	public void addBonus(Bonus b);
	
	public void addPoignee(Poignee poignee);
	
	public void setPetitAuBout(PetitAuBout pab);
	
	
	
	public interface Actionable {
		
		public void onAskTaker(List<Player> players);
		
		public void onBiddingSelected();

		public void onTeamsCompleted();

		public void onNbBoutsSet();

		public void onScoreUpdated();

		public void onAskPetitAuBon();

		public void onAskPoignee();

		public void onAskJeuBlanc();

		public void onAskPenalty();

		public void onAskChelem();

		public void onBonusUpdated();

		public void onPoigneesUpdated();

		public void onPetitAuBoutUpdated();

	}






















}
