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
