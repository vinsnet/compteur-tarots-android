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
package fr.vinsnet.compteurtarot.model;

public class SimplePoignee extends Poignee {

	
	
	public static final int TYPE = 1;

	public SimplePoignee(long id, Player player) {
		super(id, player);
	}

	public SimplePoignee(Player player) {
		this(0,player);
	}
	public SimplePoignee() {
		this(null);
	}
	

	@Override
	public int getType() {
		return TYPE;
	}
	
	@Override
	public String getLabel() {
		return "Simple poignée";
	}
}
