package fr.vinsnet.compteurtarot.model;

public abstract class JeuBlanc extends Bonus {

	
	private static final int VALUE = 10;

	public JeuBlanc(long id, Player player) {
		super(id, VALUE, player);
	}



}
