package fr.vinsnet.compteurtarot.parcels;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.JeuBlancAtout;
import fr.vinsnet.compteurtarot.model.JeuBlancTete;
import fr.vinsnet.compteurtarot.model.Penalty;

public class BonusParcel extends WithFuturPlayer implements Parcelable {

	static final String TAG = "BonusParcel";
	private Bonus bonus;

	public BonusParcel(Bonus b) {
		this.bonus = b;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public void writeToParcel(Parcel dest, int flag) {
		Log.v(TAG, "writeToParcel");
		dest.writeInt(bonus.getType());
		dest.writeLong(bonus.getId());
		writeFuturePlayer(dest,bonus.getPlayer());
		//source.writeInt(bonus.getValue());
	}

	public static BonusParcel bonusFromParcel(Parcel source) {
		Log.v(TAG, "bonusFromParcel");
		
		Bonus b = readBonusType(source);
		readId(b, source);
		readFuturPlayer(b, source);
		
		return new BonusParcel(b);
	}

	protected static void readFuturPlayer(Bonus b, Parcel source) {
		b.setPlayer(WithFuturPlayer.readFuturPlayer(source));
		
	}

	protected static void readId(Bonus b, Parcel source) {
		Log.v(TAG,"readId");
		b.setId(source.readLong());
		
	}

	protected static Bonus  readBonusType(Parcel source) {
		int type = source.readInt();
		switch(type){
		case JeuBlancAtout.TYPE : return new JeuBlancAtout();
		case JeuBlancTete.TYPE : return new JeuBlancTete();
		case Penalty.TYPE : return new Penalty();
		default : return null;
		}
	}
	


	public static final Parcelable.Creator<BonusParcel> CREATOR = new Parcelable.Creator<BonusParcel>() {
		// @Override
		public BonusParcel createFromParcel(Parcel source) {
			return bonusFromParcel(source);
		}

		// @Override
		public BonusParcel[] newArray(int size) {

			return new BonusParcel[size];
		}
	};

	public int describeContents() {
		return 0;
	}

}
