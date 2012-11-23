package fr.vinsnet.compteurtarot.model.futur.bid;

import java.util.List;

import fr.vinsnet.compteurtarot.model.Bid;

public class FakeFuturBid extends Bid {

	
	@Override
	public int getType() {
		throw new RuntimeException("FakeFuturBid");
	}
	
	public void loadWithBids(List<Bid> bids) {
		throw new RuntimeException("FakeFuturBid");
	}

	@Override
	public int getMultiply() {
		throw new RuntimeException("FakeFuturBid");
	}

	@Override
	public void setMultiply(int multiply) {
		throw new RuntimeException("FakeFuturBid");
	}

	@Override
	public String getName() {
		throw new RuntimeException("FakeFuturBid");
	}

	@Override
	public void setName(String name) {
		throw new RuntimeException("FakeFuturBid");
	}

	@Override
	public int getValue() {
		throw new RuntimeException("FakeFuturBid");
	}

	@Override
	public void setValue(int value) {
		throw new RuntimeException("FakeFuturBid");
	}





}
