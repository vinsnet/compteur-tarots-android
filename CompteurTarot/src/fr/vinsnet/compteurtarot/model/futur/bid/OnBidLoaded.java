package fr.vinsnet.compteurtarot.model.futur.bid;

import java.util.List;

import fr.vinsnet.compteurtarot.model.Bid;

public interface OnBidLoaded {
	/**
	 * methode to start load FuturBid
	 * 
	 * @param bids list of loaded bids
	 */
	public void loadWithBids(List<Bid> bids);
}
