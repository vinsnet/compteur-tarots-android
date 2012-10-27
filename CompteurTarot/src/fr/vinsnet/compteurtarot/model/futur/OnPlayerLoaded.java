package fr.vinsnet.compteurtarot.model.futur;

import java.util.List;

import fr.vinsnet.compteurtarot.model.Player;

public interface OnPlayerLoaded {

	/**
	 * methode to start load FuturPlayer
	 * 
	 * @param g
	 */
	public abstract void loadWithPlayers(List<Player> g);

}