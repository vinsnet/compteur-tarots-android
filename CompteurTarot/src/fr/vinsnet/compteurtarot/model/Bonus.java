package fr.vinsnet.compteurtarot.model;

public abstract class Bonus {
 private long id;
 private int value;
 private Player player;
 
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
public abstract int getType();
public abstract String getLabel();
 
}
