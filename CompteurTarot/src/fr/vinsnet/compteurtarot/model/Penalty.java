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

public class Penalty extends Bonus {

	public static final int TYPE=1;
	public static final int VALUE=-10;
	
	public Penalty(long id,Player player){
		super(id, VALUE, player);
	}
	
	public Penalty(Player player){
		this(0, player);
	}
	
	public Penalty() {
		this(null);
	}

	@Override
	public int getType() {
		return TYPE;
	}

	@Override
	public String getLabel() {
		return "Penalité";
	}

}
