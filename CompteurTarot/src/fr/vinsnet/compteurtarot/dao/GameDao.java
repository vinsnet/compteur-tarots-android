package fr.vinsnet.compteurtarot.dao;

import fr.vinsnet.compteurtarot.model.Game;

public interface GameDao {

	public boolean save(Game g);

	public boolean hasSavedGame();

	public Game loadLastGame();

	
}
