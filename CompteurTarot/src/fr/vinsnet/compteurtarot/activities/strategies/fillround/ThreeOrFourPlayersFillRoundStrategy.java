package fr.vinsnet.compteurtarot.activities.strategies.fillround;

import android.util.Log;
import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Round;

/**
 * @author vinsnet
 *
 */
public  abstract class ThreeOrFourPlayersFillRoundStrategy extends CommunFillRoundStrategy {

	public ThreeOrFourPlayersFillRoundStrategy(Game game, Round currentRound, Actionable actionable) {
		super(game,currentRound ,actionable);
	}

	private static final String TAG = "ThreePlayersScoreStrategy";
	
	public void addTaker(Player taker) {
		Log.v(TAG, "preuneur : "+taker.getName());
		
		Round currentRount = getCurrentRound();
		currentRount.getTakers().add(taker);
		
		chooseDefenders();
		
	}



}
