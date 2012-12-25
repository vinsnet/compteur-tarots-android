package fr.vinsnet.compteurtarot.dao;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;

import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.Round;

public interface BonusDao {

	List<Bonus> loadBonusForRound(Round r,SQLiteDatabase db);
	
}
