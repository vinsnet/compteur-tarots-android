package fr.vinsnet.compteurtarot.model;

public class TriplePoignee extends Poignee {
	public static final int TYPE = 3;

	public TriplePoignee(long id, Player player) {
		super(id, player);
	}

	public TriplePoignee(Player player) {
		this(0,player);
	}

	public TriplePoignee() {
		this(null);
	}

	@Override
	public int getType() {
		return TYPE;
	}
	@Override
	public String getLabel() {
		return "Triple poignée";
	}
}
