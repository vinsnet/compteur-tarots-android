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

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import fr.vinsnet.compteurtarot.model.Bid;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.PetitAuBout;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Poignee;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.compteurtarot.model.future.bid.FutureBid;

public class RoundParcel extends WithFuturPlayer implements Parcelable {

	private static final String TAG = "RoundParcel";
	private static final byte PaB_FOR_TAKERS = 1;
	private static final byte PaB_FOR_DEFENDERS = 0;
	private Round round;

	public RoundParcel(Round round) {
		this.round = round;
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel parcel, int flag) {
		if (round == null) {
			return;
		}
		Log.d(TAG, "debut de lecture d'un round");
		writeid(parcel, flag);
		writeBiddind(parcel, flag);
		writeNbBoutsTakers(parcel, flag);
		writeScoreTakers(parcel, flag);
		writeTakers(parcel, flag);
		writeDefenders(parcel, flag);
		writePetitAuBout(parcel, flag);
		writePoignees(parcel, flag);
		writeBonus(parcel, flag);
	}

	private void writeid(Parcel parcel, int flag) {
		parcel.writeLong(round.getId());

	}

	private void writeBiddind(Parcel parcel, int flag) {
		if (round.isUnsetBidding()) {
			parcel.writeInt(0);
		} else {
			Bid b = round.getBidding();
			parcel.writeInt(b.getType());
		}

	}

	private void writeNbBoutsTakers(Parcel parcel, int flag) {
		parcel.writeInt(round.getNbBoutsTakers());

	}

	private void writeScoreTakers(Parcel parcel, int flag) {
		parcel.writeFloat(round.getScoreTakers());
	}

	private void writeTakers(Parcel parcel, int flag) {
		List<Player> takers = round.getTakers();
		parcel.writeInt(takers.size());
		for (Player p : takers) {
			writeFuturePlayer(parcel, p);
		}
	}

	private void writeDefenders(Parcel parcel, int flag) {
		List<Player> defenders = round.getDefenders();
		parcel.writeInt(defenders.size());
		for (Player p : defenders) {
			writeFuturePlayer(parcel, p);
		}

	}

	private void writePetitAuBout(Parcel parcel, int flag) {

		if (round.isPetitAuBout()) {
			parcel.writeByte((byte) 1);
			if (round.getPetitAuBout().isForTakers()) {
				parcel.writeByte((byte) PaB_FOR_TAKERS);
			} else {
				parcel.writeByte((byte) PaB_FOR_DEFENDERS);
			}
		} else {
			parcel.writeByte((byte) 0);
		}

	}

	private void writePoignees(Parcel parcel, int flag) {
		List<Poignee> poignees = round.getPoignees();
		parcel.writeInt(poignees.size());
		for (Poignee p : poignees) {
			new PoigneeParcel(p).writeToParcel(parcel, flag);
		}

	}

	private void writeBonus(Parcel parcel, int flag) {
		List<Bonus> bonus = round.getBonus();
		parcel.writeInt(bonus.size());
		for (Bonus b : bonus) {
			new BonusParcel(b).writeToParcel(parcel, flag);
		}
	}

	public Round getRound() {
		return round;
	}

	public static RoundParcel roundFromParcel(Parcel source) {
		Round round = new Round();
		RoundParcel parcel = new RoundParcel(round);
		parcel.readId(source);
		parcel.readBiddind(source);
		parcel.readNbBoutsTakers(source);
		parcel.readScoreTakers(source);
		parcel.readTakers(source);
		parcel.readDefenders(source);
		parcel.readPetitAuBout(source);
		parcel.readPoignees(source);
		parcel.readBonus(source);
		return parcel;
	}

	private void readBonus(Parcel source) {
		int size = source.readInt();
		for (int i = 0; i < size; i++) {
			round.addBonus(readOneBonus(source));
		}
	}

	private Bonus readOneBonus(Parcel source) {
		Log.v(TAG, "readOneBonus");
		return BonusParcel.bonusFromParcel(source).getBonus();
	}

	private void readPoignees(Parcel source) {
		int size = source.readInt();
		for (int i = 0; i < size; i++) {
			round.getPoignees().add(readPoignee(source));
		}
	}

	private Poignee readPoignee(Parcel source) {
		return PoigneeParcel.poigneeFromParcel(source).getPoignee();
	}

	private void readPetitAuBout(Parcel source) {

		boolean isPetitAuBout = source.readByte() != 0;
		if (isPetitAuBout) {
			round.setPetitAuBout(new PetitAuBout(
					source.readByte() == PaB_FOR_TAKERS));
		}

	}

	private void readDefenders(Parcel source) {
		int size = source.readInt();
		for (int i = 0; i < size; i++) {
			round.getDefenders().add(readPlayer(source));
		}
	}

	private void readNbBoutsTakers(Parcel source) {
		round.setNbBoutsTakers(source.readInt());
	}

	private void readScoreTakers(Parcel source) {
		round.setScoreTakers(source.readFloat());
	}

	private void readTakers(Parcel source) {
		int size = source.readInt();
		for (int i = 0; i < size; i++) {
			round.getTakers().add(readPlayer(source));
		}
	}

	protected Player readPlayer(Parcel source) {
		return WithFuturPlayer.readFuturPlayer(source);
	}

	private void readBiddind(Parcel source) {
		int bidType = source.readInt();
		if (bidType == 0) {
			round.setbidding(null);
		} else {
			round.setbidding(new FutureBid(bidType));
		}
	}

	private void readId(Parcel source) {
		round.setId(source.readLong());
	} 

	public static final Parcelable.Creator<RoundParcel> CREATOR = new Parcelable.Creator<RoundParcel>() {
		// @Override
		public RoundParcel createFromParcel(Parcel source) {
			return roundFromParcel(source);
		}

		// @Override
		public RoundParcel[] newArray(int size) {

			return new RoundParcel[size];
		}
	};

}
