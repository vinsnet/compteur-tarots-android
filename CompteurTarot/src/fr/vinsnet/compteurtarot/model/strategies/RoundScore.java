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
package fr.vinsnet.compteurtarot.model.strategies;

import fr.vinsnet.compteurtarot.model.Player;

public class RoundScore {

	
	RoundScore previousScore;
	
	RoundResult round;
	
	public float getScoreFor(Player p){
		float previousTotal = 0;
		if(previousScore!=null){
			previousTotal = previousScore.getScoreFor(p);
		}
		return previousTotal + round.getDetailedScores().get(p.getId());
	}

	public RoundScore(RoundScore previousScore, RoundResult round) {
		super();
		this.previousScore = previousScore;
		this.round = round;
	}

	public RoundScore getPreviousScore() {
		return previousScore;
	}

	public RoundResult getRound() {
		return round;
	}
	
	
}
