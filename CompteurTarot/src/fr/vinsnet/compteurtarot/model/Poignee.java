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


public abstract class Poignee {

	public Poignee(long id,Player player ) {
		super();
		this.player = player;
		this.id = id;
	}

	private Player player;
	
	private long id;
	
	
	public long getId() {
		return id;
	}
	
	public void setPlayer(Player p) {
		this.player = p;
		
	}

	public Player getPlayer() {
		return player;
	}
	
	public  abstract int  getType();

	public abstract String getLabel();

	public void setId(long id) {
		this.id=id;
	}

}
