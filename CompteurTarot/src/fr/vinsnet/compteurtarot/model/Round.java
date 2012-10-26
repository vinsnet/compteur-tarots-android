package fr.vinsnet.compteurtarot.model;

import java.util.ArrayList;
import java.util.List;


public class Round {

	private static final int NB_BOUTS = 3;
	public static final int MAX_SCORE= 91;
	
	private long id;
	private List<Player> takers;
	private List<Player> defenders;
	private int nbBoutsTakers=-1;
	private float scoreTakers=-1;
	private PetitAuBout petitAuBout;
	private List<Poignee> poignees;
	private List<Bonus> bonus;
	private Bid bidding;
	
	public Round() {
		takers = new ArrayList<Player>();
		defenders = new ArrayList<Player>();
		poignees = new ArrayList<Poignee>();
		bonus = new ArrayList<Bonus>();
		petitAuBout = null;
		bidding=null;
		nbBoutsTakers=-1;
		scoreTakers=-1;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
	
	public float getScoreTakers() {
		//if(scoreTakers==-1)return -1;
		return scoreTakers;
	}

	public void setScoreTakers(float scoreTakers) {
		this.scoreTakers = scoreTakers;
	}
	
	public float getScoreDefenders() {
		if(scoreTakers==-1)return -1;
		return MAX_SCORE-scoreTakers;
	}

	public void setScoreDefenders(float scoreDefenders) {
		this.scoreTakers = MAX_SCORE-scoreDefenders;
	}

	public List<Player> getTakers() {
		return takers;
	}

	public List<Poignee> getPoignees() {
		return poignees;
	}

	public int getNbBoutsTakers() {
		if(nbBoutsTakers==-1)return -1;
		return nbBoutsTakers;
	}

	public void setNbBoutsTakers(int nbBoutsTakers) {
		this.nbBoutsTakers = nbBoutsTakers;
	}
	public int getNbBoutsDefenders() {
		if(nbBoutsTakers==-1)return -1;
		return NB_BOUTS-nbBoutsTakers;
	}

	public void setNbBoutsDefenders(int nbBoutsDefenders) {
		this.nbBoutsTakers = NB_BOUTS-nbBoutsTakers;
	}

	public PetitAuBout getPetitAuBout() {
		return petitAuBout;
	}

	public void setPetitAuBout(PetitAuBout petitAuBout) {
		this.petitAuBout = petitAuBout;
	}

	public List<Player> getDefenders() {
		return defenders;
	}

	public List<Bonus> getBonus() {
		return bonus;
	}

	public void setbidding(Bid bidding) {
		this.bidding = bidding;
		
	}
	public Bid getBidding( ) {
		return bidding;
		
	}

	public void clearTeams() {
		takers = new ArrayList<Player>();
		defenders = new ArrayList<Player>();
		
	}

	public boolean isUnsetScore() {
		return getScoreTakers()==-1;
	}

	public boolean isUnsetNbBouts() {
		return getNbBoutsTakers()==-1;
	}

	public boolean isPetitAuBout() {
		return petitAuBout!=null;
	}

	public boolean isUnsetBidding() {
		return bidding==null;
	}

	/**
	 * ask to all FuturPlayers to be loaded
	 */
	public void loadPlayers() {
		List<Player> players = new ArrayList<Player>(getDefenders()) ;
		players.addAll(getTakers());
		
		for( Poignee p : getPoignees()){
			p.getPlayer().loadWithPlayers(players);
		}
		
	}


	
	
}
