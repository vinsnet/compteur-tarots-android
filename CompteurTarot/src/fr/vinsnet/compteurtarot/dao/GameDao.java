package fr.vinsnet.compteurtarot.dao;

import fr.vinsnet.compteurtarot.model.Game;

public interface GameDao {
	
	public boolean updateOrCreate(Game g);

	public boolean hasSavedGame();

	public Game loadLastGame();

	public Game loadGame(long id);


	
}
