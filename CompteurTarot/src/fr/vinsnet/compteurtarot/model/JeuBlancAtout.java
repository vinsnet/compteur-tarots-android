package fr.vinsnet.compteurtarot.model;

public class JeuBlancAtout extends JeuBlanc {

	public JeuBlancAtout(long id, Player player) {
		super(id, player);
	}

	public JeuBlancAtout(Player player) {
		this(0,player);
	}

	public JeuBlancAtout() {
		this(null);
	}

	public static final int TYPE = 2;

	@Override
	public int getType() {
		return TYPE;
	}

	@Override
	public String getLabel() {
		return "Jeu blanc d'atout";
	}

}
