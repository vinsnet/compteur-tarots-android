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
package fr.vinsnet.compteurtarot.dao;

import android.content.Context;
import fr.vinsnet.compteurtarot.model.Game;

public interface GameDao {
	
	public boolean updateOrCreate(Game g);

	public boolean hasSavedGame();

	//XXX context should be removed when bid will be moved in dao
	public Game loadLastGame(Context c);

	//XXX context should be removed when bid will be moved in dao
	public Game loadGame(long id,Context c);


	
}
