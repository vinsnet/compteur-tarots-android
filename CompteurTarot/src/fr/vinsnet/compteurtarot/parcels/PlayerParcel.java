/*******************************************************************************
 * Copyright (c) 2012 vinsnet<vinsnet@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     vinsnet<vinsnet@gmail.com> - initial API and implementation
 ******************************************************************************/
package fr.vinsnet.compteurtarot.parcels;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import fr.vinsnet.compteurtarot.model.Player;

public class PlayerParcel implements Parcelable {

	private Player player;

	public PlayerParcel(Player p) {	
		this.player= p;
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel dest, int flags) {
		writeId(dest);		
		writeContactId(dest);
		writeName(dest);
		writeContactUri(dest);

	}
	
    private void writeContactUri(Parcel dest) {
		dest.writeString(player.getContactUri().toString());
		
	}

	private void writeName(Parcel dest) {
		dest.writeString(player.getName());
		
	}

	private void writeContactId(Parcel dest) {
		dest.writeLong(player.getContactId());
		
	}
	private void writeId(Parcel dest) {
		dest.writeLong(player.getId());
		
	}

	public static PlayerParcel playerFromParcel(Parcel source) {
		Player player = new Player();
		readId(player, source);
		readContactId(player, source);
		readName(player, source);
		readContactUri(player, source);
		
		return new PlayerParcel(player);
	}
	
	
	private static void readContactUri(Player player, Parcel source) {
		player.setContactUri(Uri.parse(source.readString()));
		
	}

	private static void readName(Player player, Parcel source) {
		player.setName(source.readString());
		
	}

	private static void readContactId(Player player, Parcel source) {
		player.setContactId(source.readLong());
		
	}
	private static void readId(Player player, Parcel source) {
		player.setId(source.readLong());
		
	}


	public static final Parcelable.Creator<PlayerParcel> CREATOR = new Parcelable.Creator<PlayerParcel>()
			{
			   // @Override
			    public PlayerParcel createFromParcel(Parcel source)
			    {
			        return playerFromParcel(source);
			    }



				//@Override
			    public PlayerParcel[] newArray(int size)
			    {
			    	
			    	return new PlayerParcel[size];
			    }
			};

			public Player getPlayer() {
				return player;
			}

}
