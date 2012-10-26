package fr.vinsnet.compteurtarot.dao;

import android.content.Context;

public interface DaoFactory {

	GameDao getGameDao(Context context);
	
}
