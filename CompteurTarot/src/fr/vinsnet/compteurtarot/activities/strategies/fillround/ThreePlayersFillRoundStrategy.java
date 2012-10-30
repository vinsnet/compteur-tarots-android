package fr.vinsnet.compteurtarot.activities.strategies.fillround;

import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.Round;

public class ThreePlayersFillRoundStrategy extends ThreeOrFourPlayersFillRoundStrategy
		implements FillRoundStrategy {

	public ThreePlayersFillRoundStrategy(Game game, Round currentRound, Actionable actionable) {
		super(game,currentRound, actionable);
	}

	public int getScoreIntervalDivider() {
		return 2;
	}

}
