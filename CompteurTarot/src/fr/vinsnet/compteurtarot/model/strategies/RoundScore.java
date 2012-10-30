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
