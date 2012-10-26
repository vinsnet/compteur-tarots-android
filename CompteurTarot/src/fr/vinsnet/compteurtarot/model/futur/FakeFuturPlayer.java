package fr.vinsnet.compteurtarot.model.futur;

import java.util.List;

import android.net.Uri;
import fr.vinsnet.compteurtarot.model.Player;

public class FakeFuturPlayer extends Player {

	@Override
	public long getId() {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void setId(long id) {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public long getContactId() {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void setContactId(long contactId) {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public String getName() {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void setName(String name) {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public Uri getContactUri() {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void setContactUri(Uri contactUri) {
		throw new RuntimeException("FakeFuturPlayer");
	}

	@Override
	public void loadWithPlayers(List<Player> g) {
		throw new RuntimeException("FakeFuturPlayer");
	}

}
