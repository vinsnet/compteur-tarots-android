package fr.vinsnet.compteurtarot.model;

public class Penalty extends Bonus {

	public static final int TYPE=1;
	public static final int VALUE=-10;
	
	public Penalty(long id,Player player){
		super(id, VALUE, player);
	}
	
	public Penalty(Player player){
		this(0, player);
	}
	
	@Override
	public int getType() {
		return TYPE;
	}

	@Override
	public String getLabel() {
		return "Penalité";
	}

}
