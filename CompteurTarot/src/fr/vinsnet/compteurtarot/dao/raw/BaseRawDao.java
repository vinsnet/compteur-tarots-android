package fr.vinsnet.compteurtarot.dao.raw;

import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.utils.ObjectWithId;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public abstract class BaseRawDao extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "CompteurTarotsDB";
	private static final String TAG = "BaseRawDao";
    
    BaseRawDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	public void ensureOrCreate(ObjectWithId o, SQLiteDatabase db) {
		Log.v(TAG, "ensureOrCreate");
		if (o.getId() == 0) {
			create(o, db);
		} else {
			// TODO Ensure if exist ?
		}

	}
	
	
	protected abstract void create(ObjectWithId o,SQLiteDatabase db);
	
}
