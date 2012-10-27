package fr.vinsnet.compteurtarot.model;

public class JeuBlancTete extends JeuBlanc {
	
	public JeuBlancTete(long id, Player player) {
		super(id, player);
	}
	public JeuBlancTete(Player player) {
		this(0,player);
	}

	public JeuBlancTete() {
		this(null);
	}

	public static final int TYPE = 3;

	@Override
	public int getType() {
		return TYPE;
	}

	@Override
	public String getLabel() {
		return "Jeu blanc de tete";
	}

}
