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

import fr.vinsnet.utils.ObjectWithId;


public abstract class Bonus implements ObjectWithId{
private long id;
 private int value;
 private Player player;
private Round round;
 
public Bonus(long id, int value, Player player) {
	this.id = id;
	this.value = value;
	this.player = player;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public int getValue() {
	return value;
}
public void setValue(int value) {
	this.value = value;
}
public Player getPlayer() {
	return player;
}
public void setPlayer(Player player) {
	this.player = player;
}
public void setRound(Round round) {
	this.round= round;
}
public Round getRound(){
	return round;
}


public abstract int getType();
public abstract String getLabel();


 
}
