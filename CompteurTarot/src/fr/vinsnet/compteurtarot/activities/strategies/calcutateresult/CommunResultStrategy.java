package fr.vinsnet.compteurtarot.activities.strategies.calcutateresult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import fr.vinsnet.compteurtarot.Utils;
import fr.vinsnet.compteurtarot.model.Bid;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.DoublePoignee;
import fr.vinsnet.compteurtarot.model.PetitAuBout;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Poignee;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.compteurtarot.model.SimplePoignee;
import fr.vinsnet.compteurtarot.model.TriplePoignee;
import fr.vinsnet.compteurtarot.model.strategies.RoundResult;

public abstract class CommunResultStrategy implements ResultStrategy {
	private static final String TAG = "CommunResultStrategy";
	private Round round;
	private List<Player> players;

	public CommunResultStrategy(Round round,List<Player> players) {
		this.setRound(round);
		this.players = players;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}
	
	
	
	public RoundResult getResult() {
		RoundResult r = new RoundResult();
		r.setSuccess(isSuccess());
		r.setScore(getScore());
		r.setTotal(getTotal());
		r.setTotalComment(getTotalComment());
		r.setDetailedScores(getDetailedScores());
		
		return r;
	}


	private Map<Long, Float> getDetailedScores() {
		Map<Long, Float> s = new HashMap<Long, Float>();
		
		dispatchPlayers(s);
		
		dispatchScore(s);
		
		dispatchBonus(s);
		
		return s;
		
	}

	private void dispatchPlayers(Map<Long, Float> s) {
		Log.v(TAG,"dispatchPlayers");
		for(Player p : players){
			s.put(p.getId(), (float) 0);
		}
		
	}

	protected void dispatchBonus(Map<Long, Float> s) {
		for(Bonus b:getRound().getBonus()){
			for(Long id :s.keySet()){
				int v=0;
				if(id==b.getPlayer().getId()){
					v= (getNbPlayer()-1)*b.getValue();
				}else{
					v= -b.getValue();
				}
				s.put(id, s.get(id)+v);
			}
		}
		
	}
	
	protected int getNbPlayer(){
		return Math.min(players.size(),5);
	}

	private void dispatchScore(Map<Long, Float> s) {
		if(!isResultAvaible())return;
		float sign = isSuccess()?1:-1;
		Round r = getRound();
		for(Player p : r.getDefenders()){
			s.put(p.getId(), (-sign*getTotal()));
		}
		Player firstTaker = getFirstTakers();
		Player secondTaker = getSecondTakers();
		if(secondTaker==null){
			s.put(firstTaker.getId(), (r.getDefenders().size()*sign*getTotal()));
		}else{
			s.put(firstTaker.getId(), ((r.getDefenders().size()-1)*sign*getTotal()));
			s.put(secondTaker.getId(), (sign*getTotal()));
		}
		
	}

	private Player getFirstTakers() {
		List<Player> takers = getRound().getTakers(); 
		if(!takers.isEmpty()){
			return takers.get(0);
		}
		return null;
	}

	private Player getSecondTakers() {
		List<Player> takers = getRound().getTakers(); 
		if(takers.size()>1){
			return takers.get(1);
		}
		return null;
	}
	protected int getTotalPoignees(){
		int result= 0;
		for(Poignee p : getRound().getPoignees()){
			result+=getValueForPoigneeType(p.getType());
		}
		return result;
	}

	private int getValueForPoigneeType(int type) {
		switch (type) {
		case SimplePoignee.TYPE:return 20;
		case DoublePoignee.TYPE:return 30;
		case TriplePoignee.TYPE:return 40;
			
		}
		return 0;
	}

	protected abstract float getTotal() ;
	protected abstract String getTotalComment();

	protected float getScore() {
		if(!isResultAvaible())return 0;
		return Math.abs(round.getScoreTakers()-getContract());
	}

	protected int getContract(){
		int contract =0;
		switch(getRound().getNbBoutsTakers()){
		case 0: contract=56; break;
		case 1: contract=51; break;
		case 2: contract=41; break;
		case 3: contract=36; break;	
		}
		return contract;
	}
	

	protected String getPetitAuBoutComment() {
		PetitAuBout pab = getRound().getPetitAuBout();
		if(pab==null){
			return "";
		}
		return getPetitAuBoutScore()+" [Petit au bout] ";
	}
	
	public boolean isResultAvaible() {
		return round.getBidding()!=null &&
				! round.getTakers().isEmpty() &&
				! round.isUnsetScore() &&
				! round.isUnsetNbBouts();
	}
	
	protected boolean isSuccess() {
		int contract = getContract();
		return getRound().getScoreTakers()>=contract;
	}
	

	
	public List<Bid> getBidList(Context context) {
		return Utils.getBidList(context);
		//TODO read Bids config From DB
		//TODO only the name in configuration files
		
	}
}
