package fr.vinsnet.compteurtarot.activities.strategies.calcutateresult;

import fr.vinsnet.compteurtarot.model.Bid;
import fr.vinsnet.compteurtarot.model.PetitAuBout;
import fr.vinsnet.compteurtarot.model.Round;

public class WikipediaResultStrategy  extends CommunResultStrategy {

	private static int CONTRACT_VALUE = 25;

	public WikipediaResultStrategy(Round round) {
		super(round);
	}

	@Override
	protected float getTotal() {
		Bid b = getRound().getBidding();
		
		return ((CONTRACT_VALUE + getScore() +getPetitAuBoutScore())*b.getMultiply())+getTotalPoignees();
	}

	
	public int getPetitAuBoutScore(){
		PetitAuBout pab = getRound().getPetitAuBout();
		if(pab==null){
			return 0;
		}
		return (pab.isForTakers()?1:-1)*10;
	}
	
	@Override
	protected String getTotalComment() {
		Bid b = getRound().getBidding();
		int totalPoignee= getTotalPoignees();
		String poignee = "";
		if(totalPoignee!=0){
			poignee=" + "+totalPoignee+" [poignee"+((getRound().getPoignees().size()>1)?"s":"")+"]";
		}
		return "( "+25+ " + "+getScore()+" + "+getPetitAuBoutComment()+" ) x "+b.getMultiply()+"["+b.getName()+"]"+poignee;
	}



}
