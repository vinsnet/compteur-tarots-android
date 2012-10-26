package fr.vinsnet.compteurtarot.model;

public class Bid {

	private String name;
	private int value;
	private int multiply;
	
	public Bid(String name, int value, int multiply) {
		super();
		this.name = name;
		this.value = value;
		this.multiply=multiply;
	}
	public int getMultiply() {
		return multiply;
	}
	public void setMultiply(int multiply) {
		this.multiply = multiply;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
