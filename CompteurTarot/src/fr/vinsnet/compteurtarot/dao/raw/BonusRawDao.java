package fr.vinsnet.compteurtarot.dao.raw;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import fr.vinsnet.compteurtarot.dao.BonusDao;
import fr.vinsnet.compteurtarot.model.Bonus;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.compteurtarot.model.future.player.FuturePlayer;
import fr.vinsnet.utils.ObjectWithId;

public class BonusRawDao extends BaseRawDao implements BonusDao {

	private static final String TAG = "BonusRawDao";
	private static final String TABLE_NAME = "bonus";
	

	private static final String KEY_PLAYER_ID = "id_player";
	private static final String KEY_ROUND_ID = "id_round";
	private static final String KEY_CLASS = "class";
	
	private static final String BONUS_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME  + " (" +
			KEY_ID	+ " integer primary key autoincrement, " +
			KEY_PLAYER_ID + " integer  constraint fk_player references " + PlayerRawDao.TABLE_NAME +","+ //TODO oncascade
			KEY_ROUND_ID + " integer  constraint fk_round references " + RoundRawDao.TABLE_NAME +","+
			KEY_CLASS + " text "+ 
			
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
		if(b.getId()<=0){
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
		c.put(KEY_PLAYER_ID, b.getPlayer().getId());
		c.put(KEY_ROUND_ID, b.getRound().getId());
		c.put(KEY_CLASS, b.getClass().getCanonicalName());
		return c;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.v(TAG,"onCreate");
		Log.v(TAG,BONUS_TABLE_CREATE);
		db.execSQL(BONUS_TABLE_CREATE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.v(TAG,"onUpgrade");
		throw new RuntimeException("Not Yet implemented exception");
	}

	public List<Bonus> loadBonusForRound(Round r,SQLiteDatabase db) {
		Log.v(TAG,"loadBonusForRound");
		
		Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_ID,KEY_PLAYER_ID,KEY_ROUND_ID,KEY_CLASS}, KEY_ROUND_ID + " = ? ",new  String[]{""+r.getId()}, null, null, null);
		
		List<Bonus> bonus = new ArrayList<Bonus>(cursor.getCount());
		
		if(!cursor.moveToFirst()){
			return bonus;
		}
		
		while (!cursor.isAfterLast()){
			
			Bonus b = newBonusFromCursor( cursor, db);
			bonus.add(b);
			cursor.moveToNext();
		}
		return bonus;
	}

	protected Bonus newBonusFromCursor(Cursor cursor, SQLiteDatabase db) {

		String classname = cursor.getString(cursor.getColumnIndex(KEY_CLASS));
		//TODO probleme de securité : on peut charger la classe que l'on veut....
		Bonus b;
		try {
			b = (Bonus) Class.forName(classname).newInstance();
			b.setPlayer(new FuturePlayer(cursor.getLong(cursor.getColumnIndex(KEY_PLAYER_ID))));
			b.setId(cursor.getLong(cursor.getColumnIndex(KEY_ID)));
			return b;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}




}
