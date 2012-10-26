package fr.vinsnet.compteurtarot.activities.resultstrategy;

import java.util.List;

import android.content.Context;
import fr.vinsnet.compteurtarot.model.Bid;
import fr.vinsnet.compteurtarot.model.strategies.RoundResult;

public interface ResultStrategy {

	RoundResult getResult();
	public boolean isResultAvaible() ;
	int getPetitAuBoutScore();

	public List<Bid> getBidList(Context context);
}
