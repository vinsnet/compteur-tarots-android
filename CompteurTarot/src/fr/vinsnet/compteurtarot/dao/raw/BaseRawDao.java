package fr.vinsnet.compteurtarot.dao.raw;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class BaseRawDao extends SQLiteOpenHelper{

	private static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "CompteurTarotsDB";
    
    BaseRawDao(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

   
	
}
