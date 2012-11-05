package fr.vinsnet.compteurtarot.dao.raw;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import fr.vinsnet.utils.ObjectWithId;

public abstract class BaseRawDao extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "CompteurTarotsDB";
	private static final String TAG = "BaseRawDao";
    
    BaseRawDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	public boolean updateOrCreate(ObjectWithId o, SQLiteDatabase db) {
		Log.v(TAG, "ensureOrCreate");
		if (o.getId() == 0) {
			return create(o, db);
		} else {
			// TODO Ensure if exist ?
		}
		return false;
	}
	
	public boolean updateOrCreate(ObjectWithId o) {
		SQLiteDatabase db =null;
		boolean succes = false;
		try{
		db= this.getWritableDatabase();
		db.beginTransaction();


		succes =  updateOrCreate(o,db);
		db.endTransaction();
		}catch(Throwable e){
			Log.w(TAG, e.getMessage());
		}
		db.close();

		return succes;
	}
	
	
	protected abstract boolean create(ObjectWithId o,SQLiteDatabase db);
	
}
