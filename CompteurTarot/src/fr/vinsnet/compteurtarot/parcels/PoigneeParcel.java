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

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import fr.vinsnet.compteurtarot.model.DoublePoignee;
import fr.vinsnet.compteurtarot.model.Poignee;
import fr.vinsnet.compteurtarot.model.SimplePoignee;
import fr.vinsnet.compteurtarot.model.TriplePoignee;

public class PoigneeParcel extends WithFuturPlayer implements Parcelable{

	static final String TAG = "PoigneeParcel";
	private Poignee poignee;

	public PoigneeParcel(Poignee p) {
		this.poignee = p;
	}

	public int describeContents() {
		return 0;
	}
	
	public void writeToParcel(Parcel parcel, int flag) {

		parcel.writeInt(poignee.getType());
		parcel.writeLong(poignee.getId());
		writeFuturePlayer(parcel, poignee.getPlayer());
		
	}

	public static PoigneeParcel poigneeFromParcel(Parcel source) {
		Log.v(TAG,"poigneeFromParcel");
		Poignee p = readType(source);
		readId(p, source);
		readPlayer(p, source);
		
		return new PoigneeParcel(p);
	}

	protected static void readPlayer(Poignee p, Parcel source) {
		p.setPlayer(WithFuturPlayer.readFuturPlayer(source));
		
	}

	protected static void readId(Poignee p, Parcel source) {
		Log.v(TAG,"readId");
		p.setId(source.readLong());
		
	}

	protected static Poignee readType(Parcel source) {
		int type = source.readInt();
		switch(type){
		case SimplePoignee.TYPE : return new SimplePoignee();
		case DoublePoignee.TYPE : return new DoublePoignee();
		case TriplePoignee.TYPE : return new TriplePoignee();
		default : return null;
		}
	}

	public Poignee getPoignee() {
		return poignee;
	}

	
	
	

	public static final Parcelable.Creator<PoigneeParcel> CREATOR = new Parcelable.Creator<PoigneeParcel>()
			{
			   // @Override
			    public PoigneeParcel createFromParcel(Parcel source)
			    {
			        return poigneeFromParcel(source);
			    }



				//@Override
			    public PoigneeParcel[] newArray(int size)
			    {
			    	
			    	return new PoigneeParcel[size];
			    }
			};

			public Poignee getPlayer() {
				return poignee;
			}

}
	
	

