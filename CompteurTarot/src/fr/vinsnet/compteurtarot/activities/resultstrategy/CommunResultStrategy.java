package fr.vinsnet.compteurtarot.activities.resultstrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import fr.vinsnet.compteurtarot.R;
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
	private Round round;

	public CommunResultStrategy(Round round) {
		this.setRound(round);
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
		
		dispatchScore(s);
		
		dispatchBonus(s);
		
		return s;
		
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
		return getRound().getTakers().size()+ getRound().getDefenders().size();
	}

	private void dispatchScore(Map<Long, Float> s) {
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
		Resources res = context.getResources();
		String[] bidNames = res.getStringArray(R.array.bidName);
		int[] bidValues = res.getIntArray(R.array.bidValue);
		int[] bidMultiply = res.getIntArray(R.array.bidMultiply);
		
		List<Bid> bids = new ArrayList<Bid>(bidNames.length);
		for(int i=0;i<bidNames.length;i++){
			bids.add(new Bid(bidNames[i], bidValues[i], bidMultiply[i]));
		}
		return bids;
	}
}
