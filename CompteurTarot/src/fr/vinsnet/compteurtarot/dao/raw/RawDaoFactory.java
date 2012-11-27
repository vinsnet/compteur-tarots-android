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
package fr.vinsnet.compteurtarot.dao.raw;

import android.content.Context;
import fr.vinsnet.compteurtarot.dao.DaoFactory;
import fr.vinsnet.compteurtarot.dao.GameDao;
import fr.vinsnet.compteurtarot.dao.PlayerDao;

public class RawDaoFactory implements DaoFactory {

	
	private static final DaoFactory SINGLETON_FACTORY = new RawDaoFactory();

	public static DaoFactory getInstance(){
		return SINGLETON_FACTORY;
	}
	
	public GameDao getGameDao(Context context) {
		return new GameRawDao(context);
	}

	public PlayerDao getPlayerDao(Context context) {
		return new PlayerRawDao(context);
	}

	
	
}
