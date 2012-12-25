package fr.vinsnet.compteurtarot.dao.raw;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import fr.vinsnet.compteurtarot.dao.BonusDao;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.utils.ObjectWithId;

public class BonusRawDao extends BaseRawDao implements BonusDao {

	private static final String TAG = "BonusRawDao";
	private static final String TABLE_NAME = "bonus";
	private static final String BONUS_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME  + " (" +
			KEY_ID	+ " integer primary key autoincrement, " +

		");";
	
	private static final String KEY_PLAYER_ID = "id_player";
	private static final String KEY_ROUND_ID = "id_round";
	private static final String KEY_CLASS = "class";
	
	
	
	private static final String GAME_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" +
			KEY_ID	+ " integer primary key autoincrement, " +
			KEY_PLAYER_ID + "integer constraint fk_player references " + PlayerRawDao.TABLE_NAME + " , "+
			KEY_ROUND_ID + "integer constraint fk_round references " + RoundRawDao.TABLE_NAME + " , "+
			KEY_CLASS + "text" +
			");";
	
	BonusRawDao(Context context) {
		super(context);
	}

	@Override
	public boolean updateOrCreate(ObjectWithId o, SQLiteDatabase db) {
		Log.v(TAG,"mergeOrCreate");
		return save((Bonus)o,db)>0;
	}

	private long save(Bonus b, SQLiteDatabase db) {
		long k;
		if(b.getId()>=0){
			k = db.insertOrThrow(TABLE_NAME, KEY_ID, getContentValues(b));
			b.setId(k);
		} else {
			k = db.update(TABLE_NAME, getContentValues(b), KEY_ID + "=?",
					new String[] { "" + b.getId() });
		}
		return b.getId();
	}

	private ContentValues getContentValues(Bonus b) {
		ContentValues c = new ContentValues();
		c.put(KEY_ID, b.getId());
		c.put(KEY_PLAYER_ID, b.getPlayer().getId());
		c.put(KEY_ROUND_ID, b.getRound().getId());
		c.put(KEY_CLASS, b.getClass().getCanonicalName());
		return c;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.v(TAG,"onCreate");

		db.execSQL(BONUS_TABLE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onUpgrade");
		
	}



}
