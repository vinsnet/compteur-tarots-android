package fr.vinsnet.compteurtarot.model;

public class DoublePoignee extends Poignee {

	
	public static final int TYPE = 2;

	public DoublePoignee(long id, Player player) {
		super(id, player);
	}

	public DoublePoignee(Player player) {
		this(0,player);
	}

	public DoublePoignee() {
		this(null);
	}

	@Override
	public int getType() {
		return TYPE;
	}

	@Override
	public String getLabel() {
		return "Double poignée";
	}

}
