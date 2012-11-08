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
