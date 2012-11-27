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

import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Round;

public class FivePlayersFillRoundStrategy extends CommunFillRoundStrategy {

	public FivePlayersFillRoundStrategy(Game game,Round currentRound,
			FillRoundStrategy.Actionable actionable) {
		super(game,currentRound, actionable);
	}

	public void addTaker(Player taker) {
		List<Player> takers = getCurrentRound().getTakers();
		// r.getDefenders().size()

		if (takers.size() == 0) {

			takers.add(taker);
			askTaker();
		} else {
			addTakerIfNotIn(taker);
			chooseDefenders();
		}
	}

	private void addTakerIfNotIn(Player taker) {
		boolean isPresent = false;
		for (Player p : getCurrentRound().getTakers()) {
			if (taker.getId() == p.getId()) {
				isPresent = true;
			}
		}
		if (!isPresent) {
			getCurrentRound().getTakers().add(taker);
		}

	}

	public int getScoreIntervalDivider() {
		return 2;
	}

}
