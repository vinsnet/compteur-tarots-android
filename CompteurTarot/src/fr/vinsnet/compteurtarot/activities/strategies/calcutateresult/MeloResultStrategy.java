/*******************************************************************************
 * Copyright (c) 2012 vinsnet<vinsnet@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     vinsnet<vinsnet@gmail.com> - initial API and implementation
 ******************************************************************************/
package fr.vinsnet.compteurtarot.activities.strategies.calcutateresult;

import java.util.List;

import fr.vinsnet.compteurtarot.model.Bid;
import fr.vinsnet.compteurtarot.model.PetitAuBout;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Round;

public class MeloResultStrategy extends CommunResultStrategy {

	
	public MeloResultStrategy(Round round, List<Player> players) {
		super(round,players);
	}

	@Override
	protected float getScore() {

		float score = super.getScore();
		int arrondi= Math.round(score/10);
		return arrondi*10;
	}
	
	protected float getSuperScore(){
		return super.getScore();
	}
	
	public int getPetitAuBoutScore(){
		PetitAuBout pab = getRound().getPetitAuBout();
		if(pab==null){
			return 0;
		}
		return 10;
		
		
	}
	
	@Override
	protected float getTotal() {
		Bid b = getRound().getBidding();
		
		return (b==null?0:b.getValue())+getScore()+getPetitAuBoutScore()+getTotalPoignees();
	}

	@Override
	protected String getTotalComment() {
		Bid b = getRound().getBidding();
		int totalPoignee= getTotalPoignees();
		String poignee = "";
		if(totalPoignee!=0){
			poignee=" + "+totalPoignee+" (poignee"+((getRound().getPoignees().size()>1)?"s":"")+")";
		}
		String bidComment = "";
		if(b!=null){
			bidComment=b.getValue()+"("+b.getName()+") + ";
		}
		String suffix = getPetitAuBoutComment() + poignee;
		return bidComment+getScore()+"(de "+getSuperScore()+") "+(suffix.trim().length()>0 ? " + "+suffix:"");
	}




}
