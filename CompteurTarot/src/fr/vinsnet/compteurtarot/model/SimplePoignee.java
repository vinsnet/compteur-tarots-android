package fr.vinsnet.compteurtarot.model;

public class SimplePoignee extends Poignee {

	
	
	public static final int TYPE = 1;

	public SimplePoignee(long id, Player player) {
		super(id, player);
	}

	public SimplePoignee(Player player) {
		this(0,player);
	}

	@Override
	public int getType() {
		return TYPE;
	}
	
	@Override
	public String getLabel() {
		return "Simple poignée";
	}
}
