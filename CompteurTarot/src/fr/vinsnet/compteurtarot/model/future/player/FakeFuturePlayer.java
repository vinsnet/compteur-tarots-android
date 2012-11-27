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
package fr.vinsnet.compteurtarot.model.future.player;

import java.util.List;

import android.net.Uri;
import fr.vinsnet.compteurtarot.model.Player;

public class FakeFuturePlayer extends Player {

	@Override
	public long getId() {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void setId(long id) {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public long getContactId() {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void setContactId(long contactId) {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public String getName() {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void setName(String name) {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public Uri getContactUri() {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void setContactUri(Uri contactUri) {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void loadWithPlayers(List<Player> g) {
		throw new RuntimeException("FakeFuturPlayer");
	}

}
