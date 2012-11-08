package fr.vinsnet.compteurtarot.dao;

import android.database.sqlite.SQLiteDatabase;
import fr.vinsnet.compteurtarot.model.Game;

public interface RoundDao {


	void loadRoundsForGame(Game game, SQLiteDatabase db);
	
}
