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
package fr.vinsnet.compteurtarot.parcels;

import android.os.Parcel;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.future.player.FuturePlayer;

public class WithFuturPlayer {

	public WithFuturPlayer() {
		super();
	}

	protected void writeFuturePlayer(Parcel dest,Player player) {
		dest.writeLong(player.getId());
		
	}

	public static FuturePlayer readFuturPlayer(Parcel source) {
		return new FuturePlayer(source.readLong());
	}

}
