package fr.vinsnet.compteurtarot.dao.raw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import fr.vinsnet.compteurtarot.dao.GameDao;
import fr.vinsnet.compteurtarot.model.Game;
import fr.vinsnet.compteurtarot.model.Player;
import fr.vinsnet.compteurtarot.model.Round;
import fr.vinsnet.utils.ObjectWithId;

public class GameRawDao extends BaseRawDao implements GameDao {

	static final String TABLE_NAME = "games";

	private static final String KEY_ID = "id";

	private static final String KEY_STARTTIME = "startTime";

	private static final String GAME_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" + KEY_ID
			+ " integer primary key autoincrement, " + KEY_STARTTIME
			+ " integer" +

			");";

	private static final String TAG = "GameRawDao";

	private static final String JOIN_PLAYER_TABLE_NAME = "games_players";


	private static final String JOIN_ROUND_TABLE_NAME = "games_rounds";;

	private static final String KEY_ID_GAME = "id_game";

	private static final String KEY_ID_PLAYER = "id_player";
	private static final String KEY_ID_ROUND = "id_round";

	private static final String GAME_PLAYER_TABLE_CREATE = "CREATE TABLE "
			+ JOIN_PLAYER_TABLE_NAME + " (" + KEY_ID
			+ " integer primary key autoincrement, " + KEY_ID_GAME
			+ " integer constraint fk_game references " + TABLE_NAME
			+ " on delete cascade, " + KEY_ID_PLAYER
			+ " integer constraint fk_player references "
			+ PlayerRawDao.TABLE_NAME + " on delete restrict" +

			");";
	private static final String GAME_ROUND_TABLE_CREATE = "CREATE TABLE "
			+ JOIN_ROUND_TABLE_NAME + " (" + KEY_ID
			+ " integer primary key autoincrement, " + KEY_ID_GAME
			+ " integer constraint fk_game references " + TABLE_NAME
			+ " on delete cascade, " + KEY_ID_ROUND
			+ " integer constraint fk_player references "
			+ RoundRawDao.TABLE_NAME + " " +

			");";

	private PlayerRawDao playerDao;

	private RoundRawDao roundDao;

	GameRawDao(Context context) {
		super(context);
		playerDao = new PlayerRawDao(context);
		roundDao = new RoundRawDao(context);
	}

	protected boolean definePlayerGameLink(Game g, Player p, SQLiteDatabase db) {
		long k = db.insertOrThrow(JOIN_PLAYER_TABLE_NAME, KEY_ID,
				getGamePlayerJoinValues(g, p));
		return k > 0;
	}
	protected boolean defineRoundGameLink(Game g, Round r, SQLiteDatabase db) {
		long k = db.insertOrThrow(JOIN_ROUND_TABLE_NAME, KEY_ID,
				getGameRoundJoinValues(g, r));
		return k > 0;
	}

	protected boolean saveOrUpdateBaseGame(Game g, SQLiteDatabase db) {
		long k;
		if (g.getId() == 0) {
			k = db.insertOrThrow(TABLE_NAME, KEY_ID, getContentValues(g));
			g.setId(k);
		} else {
			k = db.update(TABLE_NAME, getContentValues(g), KEY_ID + "=?",
					new String[] { "" + g.getId() });
		}
		return k > 0;

	}

	public boolean save(Game g) {

		SQLiteDatabase db = null;
		boolean insertFailed = false;
		try {
			db = this.getWritableDatabase();
			db.beginTransaction();

			insertFailed |= !saveOrUpdateBaseGame(g, db);
			cleanPlayerGameJoin(g, db);
			for (Player p : g.getPlayers()) {
				playerDao.ensureOrCreate(p, db);
				insertFailed |= !definePlayerGameLink(g, p, db);
			}

			for(Round r : g.getRounds()){
				roundDao.ensureOrCreate(r, db);
				insertFailed |= !defineRoundGameLink(g, r, db);
		
			}
			
			if (!insertFailed) {
				db.setTransactionSuccessful();
			} else {
				Log.w(TAG,"transaction failed");
			}
			db.endTransaction();
		} catch (Throwable e) {
			Log.w(TAG, e.getMessage());
		}
		db.close();

		return !insertFailed;
	}

	private ContentValues getGamePlayerJoinValues(Game g, Player p) {
		ContentValues c = new ContentValues();
		c.put(KEY_ID_GAME, g.getId());
		c.put(KEY_ID_PLAYER, p.getId());
		return c;
	}
	private ContentValues getGameRoundJoinValues(Game g, Round r) {
		ContentValues c = new ContentValues();
		c.put(KEY_ID_GAME, g.getId());
		c.put(KEY_ID_PLAYER, r.getId());
		return c;
	}

	private void cleanPlayerGameJoin(Game g, SQLiteDatabase db) {
		if (g.getId() == 0) {
			return;
		}
		db.delete(JOIN_PLAYER_TABLE_NAME, KEY_ID_GAME + "=?",
				new String[] { "" + g.getId() });

	}

	private ContentValues getContentValues(Game g) {
		ContentValues c = new ContentValues();
		// if(g.getId()>0){
		// c.put(KEY_ID, g.getId());
		// }
		c.put(KEY_STARTTIME, g.getStartTime().getTime());
		return c;
	}

	public Game loadLastGame() {
		SQLiteDatabase db = this.getReadableDatabase();
		Game g = null;
		try {
			g = loadGame(getLastGameId(db), db);
		} catch (Exception e) {
			Log.e(TAG, "erreur au chargement");
			g = new Game();
		}
		db.close();
		return g;
	}

	public long getLastGameId(SQLiteDatabase db) {
		// ne pas changer l'ordre du select car utilisé pour transformer le
		// cursor en objet
		Cursor cursor = null;
		try{
			cursor = db.query(TABLE_NAME, new String[] { KEY_ID,
				KEY_STARTTIME }, null, null, null, null, KEY_STARTTIME
				+ " desc ");
			if (cursor.isAfterLast()) {
				return 0;
			}
			cursor.moveToFirst();
			return cursor.getLong(0);
		} catch (Throwable e) {
			Log.w(TAG, e.getMessage());
			return 0;
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}

	private Game loadGame(long id, SQLiteDatabase db) {
		Game game = new Game();
		if (id == 0) {
			return null;
		}
		Cursor cursor = null;
		try {
			cursor=db.query(TABLE_NAME, new String[] { KEY_ID, KEY_STARTTIME }, KEY_ID
					+ "=?", new String[] { "" + id }, null, null, KEY_STARTTIME
					+ " desc ");

			if (cursor.isAfterLast()) {
				return null;
			}
			cursor.moveToFirst();

			// voir la requete pour connaitre l'ordre
			game.setId(cursor.getLong(0));
			game.setStartTime(cursor.getLong(1));
		} catch (Throwable e) {
			Log.w(TAG, e.getMessage());
			return game;
		} finally{
			if (cursor != null) {
				cursor.close();
			}
		}
		Cursor playerIds = null;
		try {
			playerIds = db.query(true, JOIN_PLAYER_TABLE_NAME,
					new String[] { KEY_ID_PLAYER }, KEY_ID_GAME + "=?",
					new String[] { "" + game.getId() }, null, null, null, null);

			playerIds.moveToFirst();
			while (!playerIds.isAfterLast()) {
				long pid = playerIds.getLong(0);
				game.addPlayer(playerDao.load(pid, db));
				playerIds.moveToNext();
			}
		} catch (Throwable e) {
			Log.w(TAG, e.getMessage());
		} finally {
			if (playerIds != null) {
				playerIds.close();
			}
		}
		return game;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		this.playerDao.onCreate(db);
		db.execSQL(GAME_TABLE_CREATE);
		db.execSQL(GAME_PLAYER_TABLE_CREATE);
		db.execSQL(GAME_ROUND_TABLE_CREATE);

		Log.v(TAG, "creation de la table game");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		throw new RuntimeException("not yet implemented");

	}

	public boolean hasSavedGame() {

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID }, null,
				null, null, null, null);
		try {
			return !cursor.isAfterLast();
		} catch (Exception e) {
			return false;
		} finally {
			cursor.close();
			db.close();
		}
	}

	@Override
	protected void create(ObjectWithId o, SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.v(TAG,"mergeOrCreate");
		
	}

}
