package fr.vinsnet.compteurtarot.dao.raw;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import fr.vinsnet.utils.ObjectWithId;

public abstract class BaseRawDao extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "CompteurTarotsDB";
	private static final String TAG = "BaseRawDao";

	BaseRawDao(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public abstract  boolean updateOrCreate(ObjectWithId o, SQLiteDatabase db) ;


	public boolean updateOrCreate(ObjectWithId o) {
		SQLiteDatabase db = null;
		boolean succes = false;
		try {
			db = this.getWritableDatabase();
			succes = updateOrCreate(o, db);
		} catch (Throwable e) {
			Log.w(TAG, e.getMessage());
		}
		db.close();

		return succes;
	}


}
