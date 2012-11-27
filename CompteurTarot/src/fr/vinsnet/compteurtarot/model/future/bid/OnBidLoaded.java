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
package fr.vinsnet.compteurtarot.model.future.bid;

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
