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

public class FakeFutureBid extends Bid {

	
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
