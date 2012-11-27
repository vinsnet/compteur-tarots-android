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
