package fr.vinsnet.compteurtarot.parcels;

import android.os.Parcel;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.futur.player.FuturPlayer;

public class WithFuturPlayer {

	public WithFuturPlayer() {
		super();
	}

	protected void writeFuturePlayer(Parcel dest,Player player) {
		dest.writeLong(player.getId());
		
	}

	public static FuturPlayer readFuturPlayer(Parcel source) {
		return new FuturPlayer(source.readLong());
	}

}