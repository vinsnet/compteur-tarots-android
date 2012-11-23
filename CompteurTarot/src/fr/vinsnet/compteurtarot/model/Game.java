package fr.vinsnet.compteurtarot.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.activities.strategies.calcutateresult.ResultStrategy;
import fr.vinsnet.utils.ObjectWithId;

import android.util.Log;

public class Game  implements ObjectWithId{

	private long id;


	private Date startTime;
	private List<Player> players;
	private List<Round> rounds;



	public Game() {
		startTime = new Date();
		players = new ArrayList<Player>();
		rounds = new ArrayList<Round>();
		Log.d("LIST ADAPTER-Game",""+players.hashCode());
	}

	public Date getStartTime() {
		return startTime;
	}

	
	


	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
		//Log.d("LIST ADAPTER-getPlayers",""+this.players.hashCode());
		//return players;
	}

	public List<Round> getRounds() {
		return Collections.unmodifiableList(rounds);
	}

	public void setStartTime(Date date) {
		startTime = date;
	}

	public void setStartTime(Long timestamp) {
		setStartTime(new Date(timestamp));
	}

	public void setId(long id) {
		this.id = id;

	}
	public long getId() {
		return id;
	}

	public void addPlayer(Player player) {
		//TODO verifier appartenance
		players.add(player);
		Log.d("LIST ADAPTER-addPlayer",""+this.players.hashCode());
		
	}



	public ResultStrategy getNewResultStrategy(Round round) {
		return Utils.getNewDefaultResultStrategy( round,players);
	}

	public void addRound(Round round) {
		rounds.add(round);
		round.setGame(this);
	}

	public void loadFuturePlayerInAllRounds(List<Player> players) {
		for(Round r : getRounds()){
			r.loadPlayers(players);
		}
		
	}

}
