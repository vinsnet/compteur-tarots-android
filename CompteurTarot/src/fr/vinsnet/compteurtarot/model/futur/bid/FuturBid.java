package fr.vinsnet.compteurtarot.model.futur.bid;

import java.util.List;

import android.util.Log;
import fr.vinsnet.compteurtarot.model.Bid;

public class FuturBid extends Bid {

	private static final String TAG = "FuturBid";
	private Bid b;
	private int type;

	public void loadWithBids(List<Bid> bids) {
		Log.v(TAG,"loadWithGame");
		for (Bid b : bids) {//implement hashcode et equals functions for using search in array methods
			if(b.getType()==type){
				this.b=b;
				break;
			}
		}

	}

	public FuturBid(int type) {
		this.b = new FakeFuturBid();
		this.type = type;
	}

	public boolean equals(Object o) {
		if (o instanceof Bid) {
			Bid b = (Bid) o;
			return b.getType() == type;
		}
		return false;
	}

	public int getType() {
		return type;
	}

	
	
	///////////////////////////////////////
	//        delegate methods to p      //
	///////////////////////////////////////
	
	
	public int getMultiply() {
		return b.getMultiply();
	}

	public void setMultiply(int multiply) {
		b.setMultiply(multiply);
	}

	public String getName() {
		return b.getName();
	}

	public void setName(String name) {
		b.setName(name);
	}

	public int getValue() {
		return b.getValue();
	}

	public void setValue(int value) {
		b.setValue(value);
	}

	public String toString() {
		return b.toString();
	}
	
	
	

}
