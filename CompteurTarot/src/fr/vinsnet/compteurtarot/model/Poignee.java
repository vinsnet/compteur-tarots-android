package fr.vinsnet.compteurtarot.model;


public abstract class Poignee {

	public Poignee(long id,Player player ) {
		super();
		this.player = player;
		this.id = id;
	}

	private Player player;
	@SuppressWarnings("unused")
	private long id;
	
	
	public long getId() {
		return id;
	}
	
	public void setPlayer(Player p) {
		this.player = p;
		
	}

	public Player getPlayer() {
		return player;
	}
	
	public  abstract int  getType();

	public abstract String getLabel();

	public void setId(long id) {
		this.id=id;
	}

}
