package fr.vinsnet.compteurtarot.model;


import fr.vinsnet.utils.ObjectWithId;

import java.util.List;

import fr.vinsnet.compteurtarot.model.futur.player.OnPlayerLoaded;

import android.net.Uri;


public class Player implements OnPlayerLoaded,ObjectWithId  {


	private long id;
	private long contactId;
	private String name;
	private Uri contactUri;
	
	

	public void loadWithPlayers(List<Player> g) {
		//nothing to do (see futurPlayer)
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getContactId() {
		return contactId;
	}
	public void setContactId(long contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Uri getContactUri() {
		return contactUri;
	}
	public void setContactUri(Uri contactUri) {
		this.contactUri = contactUri;
	}

	
}
