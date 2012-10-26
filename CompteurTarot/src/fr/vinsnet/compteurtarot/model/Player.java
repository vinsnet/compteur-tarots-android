package fr.vinsnet.compteurtarot.model;

import fr.vinsnet.utils.ObjectWithId;
import android.net.Uri;

public class Player implements ObjectWithId {

	private long id;
	private long contactId;
	private String name;
	private Uri contactUri;
	
	
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
