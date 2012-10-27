package fr.vinsnet.compteurtarot.parcels;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.JeuBlancAtout;
import fr.vinsnet.compteurtarot.model.JeuBlancTete;
import fr.vinsnet.compteurtarot.model.Penalty;
import fr.vinsnet.compteurtarot.model.futur.FuturPlayer;

public class BonusParcel implements Parcelable {

	private static final String TAG = "BonusParcel";
	private Bonus bonus;

	public BonusParcel(Bonus b) {
		this.bonus = b;
	}

	public Bonus getBonus() {
		return bonus;
	}

	public void writeToParcel(Parcel source, int flag) {
		Log.v(TAG, "writeToParcel");
		source.writeInt(bonus.getType());
		source.writeLong(bonus.getId());
		source.writeLong(bonus.getPlayer().getId());
		//source.writeInt(bonus.getValue());
	}

	public static BonusParcel bonusFromParcel(Parcel source) {
		Log.v(TAG, "bonusFromParcel");
		
		Bonus b = readBonusType(source);
		readId(b, source);
		readPlayer(b, source);
		
		return new BonusParcel(b);
	}

	protected static void readPlayer(Bonus b, Parcel source) {
		b.setPlayer(new FuturPlayer(source.readLong()));
		
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
