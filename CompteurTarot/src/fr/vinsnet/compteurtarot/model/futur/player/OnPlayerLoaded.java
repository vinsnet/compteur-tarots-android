package fr.vinsnet.compteurtarot.model.futur.player;

import java.util.List;

import fr.vinsnet.compteurtarot.model.Player;

public interface OnPlayerLoaded {

	/**
	 * methode to start load FuturPlayer
	 * 
	 * @param player list of loaded players
	 */
	public void loadWithPlayers(List<Player> players);

}