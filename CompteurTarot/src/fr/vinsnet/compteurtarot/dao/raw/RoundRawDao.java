package fr.vinsnet.compteurtarot.dao.raw;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
	private static final String KEY_GAME_ID = "game_id";
	private static final String KEY_CREATION_TIME = "CREATION_TIME";
	private static final String KEY_UPDATE_TIME = "UPDATE_TIME";

	private static final String ROUND_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" + 
			KEY_ID	+ " integer primary key autoincrement" +
			KEY_GAME_ID + "integer constraint fk_game references" + GameRawDao.TABLE_NAME +
			KEY_CREATION_TIME + "integer" +
			KEY_UPDATE_TIME + "integer" +
			" );";


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
	
	protected long save(Round r, SQLiteDatabase db) {
		long key ;
		if(r.getId()==0){
			r.setCreationTimestamp(new Date().getTime());//TODO laisser la base faire ca ?
			key= db.insertOrThrow(TABLE_NAME, KEY_ID, getRoundBaseValues(r));
			r.setId(key);
		}else{
			r.setUpdateTimestamp(new Date().getTime());//TODO laisser la base faire ca
			/*int nbLineUpdated =*/ db.update(TABLE_NAME, getRoundBaseValues(r),KEY_ID+"=?",new String[]{""+r.getId()});

		}
		return r.getId();
	}

	protected ContentValues getRoundBaseValues(Round r) {
		
		ContentValues c = new ContentValues();
		c.put(KEY_CREATION_TIME, r.getCreationTimestamp());
		c.put(KEY_UPDATE_TIME, r.getUpdateTimestamp());
		Game g = r.getGame();
		long gameId = -1;
		if(g!=null){
			gameId = g.getId();
		}else{
			Log.w(TAG,"saving round without game");
		}
		c.put(KEY_GAME_ID, gameId);
		
		return c;
	}


	protected Round loadRoundInfos(Round round,Cursor cursor, SQLiteDatabase db) {
		Log.v(TAG,"loadGameInfos");

		// voir la requete pour connaitre l'ordre
		round.setId(cursor.getLong(0));
		round.setCreationTimestamp(cursor.getLong(1));
		round.setUpdateTimestamp(cursor.getLong(2));
		//game is set when added to game;
		Log.d(TAG,"loading round["+round.getId()+"] created at "+new Date(round.getCreationTimestamp()));
		return round;
	}

	
	public void loadRoundsForGame(Game game, SQLiteDatabase db) {
		Log.v(TAG,"loadRoundForGame");
		Cursor cursor = null;
		try {
			cursor=db.query(TABLE_NAME, new String[] { KEY_ID, KEY_CREATION_TIME,KEY_UPDATE_TIME }, KEY_GAME_ID
					+ "=?", new String[] { "" + game.getId() }, null, null, KEY_CREATION_TIME
					+ " asc ");

			cursor.moveToFirst();

			while(!cursor.isAfterLast()){
				Round r = new Round();
				loadRoundInfos(r, cursor, db);
				game.addRound(r);
			}
			
		} catch (Throwable e) {
			Log.w(TAG, e.getMessage());
		} finally{
			if (cursor != null) {
				cursor.close();
			}
		}
	}

}
