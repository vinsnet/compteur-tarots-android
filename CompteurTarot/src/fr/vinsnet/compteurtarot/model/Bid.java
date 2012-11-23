package fr.vinsnet.compteurtarot.model;

import java.util.List;

import fr.vinsnet.compteurtarot.model.future.bid.OnBidLoaded;
import android.util.Log;

public abstract class Bid implements OnBidLoaded {

	private static final String TAG = "Bid";
	private String name;
	private int value;
	private int multiply;
	
	protected Bid() {
	}
	
	public int getMultiply() {
		return multiply;
	}
	public void setMultiply(int multiply) {
		this.multiply = multiply;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public abstract int getType();
	
	public static Bid instanciateFromBidType(int bidType) {
		Log.v(TAG,"instanciateFromBidType");
		
		switch(bidType){
		case BidPetite.TYPE : return new BidPetite();
		case BidPouce.TYPE : return new BidPouce();
		case BidGarde.TYPE : return new BidGarde();
		case BidGardeSans.TYPE : return new BidGardeSans();
		case BidGardeContre.TYPE : return new BidGardeContre();
		default :
			return null;
		}
		
	}
	
	public void loadWithBids(List<Bid> bids) {
		//nothing to do, (see futurBid)
	}
	
}
