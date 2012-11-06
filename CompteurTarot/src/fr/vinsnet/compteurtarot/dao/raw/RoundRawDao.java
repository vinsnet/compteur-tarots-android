package fr.vinsnet.compteurtarot.dao.raw;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import fr.vinsnet.compteurtarot.dao.RoundDao;
import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.utils.ObjectWithId;

public class RoundRawDao extends BaseRawDao implements RoundDao {

	private static final String TAG = "RoundRawDao";
	public static final String TABLE_NAME = "rounds";

	private static final String KEY_ID = "id";

	private static final String ROUND_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" + KEY_ID
			+ " integer primary key autoincrement" +

			" );";;


	public RoundRawDao(Context context) {
		super(context);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		Log.v(TAG, "onCreate");
		db.execSQL(ROUND_TABLE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onUpgrade");
		throw new RuntimeException("not yet implemented");

		
	}


	@Override
	public boolean updateOrCreate(ObjectWithId o, SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.v(TAG,"mergeOrCreate");
		return save((Round)o,db)>0;
		
	}
	
	private long save(Round r, SQLiteDatabase db) {
		long key ;
		if(r.getId()==0){
			key= db.insertOrThrow(TABLE_NAME, KEY_ID, getRoundBaseValues(r));
		}else{
			key= db.update(TABLE_NAME, getRoundBaseValues(r),KEY_ID+"=?",new String[]{""+r.getId()});
		}
		r.setId(key);
		//TODO
		return key;
	}

	private ContentValues getRoundBaseValues(Round r) {
		//TODO
		ContentValues c = new ContentValues();
		return c;
	}




	public void loadRoundForGame(Game game, SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.v(TAG,"loadRoundForGame");
		
	}

}
