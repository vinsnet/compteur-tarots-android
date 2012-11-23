package fr.vinsnet.compteurtarot.model.futur.player;

import java.util.List;

import android.net.Uri;
import android.util.Log;
import fr.vinsnet.compteurtarot.model.Player;

public class FuturPlayer extends Player  {

	private static final String TAG = "FuturPlayer";

	Player p ;

	private long id;
	
	/* (non-Javadoc)
	 * @see fr.vinsnet.compteurtarot.model.Player#loadWithPlayers(java.util.List)
	 */
	@Override
	public void loadWithPlayers(List<Player> players) {
		Log.v(TAG,"loadWithGame");
		for (Player p : players) {
			if(p.getId()==id){
				this.p=p;
				break;
			}
		}		
	}
	
	public FuturPlayer(long id) {
		p = new FakeFuturPlayer();
		this.id = id;
	}

	
	
	public boolean equals(Object o) {
		if (o instanceof Player) {
			Player p = (Player) o;
			return p.getId() == id;
		}
		return false;
	}

	public long getId() {
		return id;
	}
	
	///////////////////////////////////////
	//        delegate methods to p      //
	///////////////////////////////////////
	


	public void setId(long id) {
		p.setId(id);
	}

	public long getContactId() {
		return p.getContactId();
	}

	public void setContactId(long contactId) {
		p.setContactId(contactId);
	}

	public String getName() {
		return p.getName();
	}

	public Uri getContactUri() {
		return p.getContactUri();
	}

	public int hashCode() {
		return p.hashCode();
	}

	public void setName(String name) {
		p.setName(name);
	}

	public void setContactUri(Uri contactUri) {
		p.setContactUri(contactUri);
	}

	public String toString() {
		return p.toString();
	}

}
