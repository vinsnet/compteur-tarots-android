package fr.vinsnet.compteurtarot.dao.raw;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import fr.vinsnet.compteurtarot.dao.PlayerDao;
import fr.vinsnet.compteurtarot.model.Player;

public class PlayerRawDao extends BaseRawDao implements PlayerDao {

	private static final String TAG = "PlayerRawDao";
	static final String TABLE_NAME = "players";

	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_CONTACT_ID = "contact_id";
	private static final String KEY_CONTACT_URI = "contact_uri";

	private static final String PLAYER_TABLE_CREATE = "CREATE TABLE "
			+ TABLE_NAME + " (" + KEY_ID
			+ " integer primary key autoincrement, " + KEY_NAME + " text, "
			+ KEY_CONTACT_ID + " integer, " + KEY_CONTACT_URI + " text " +

			" );";;

	public PlayerRawDao(Context context) {
		super(context);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.v(TAG, "onCreate");

		db.execSQL(PLAYER_TABLE_CREATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		throw new RuntimeException("not yet implemented");

	}

	public void ensureOrCreate(Player p, SQLiteDatabase db) {
		Log.v(TAG, "ensureOrCreate");
		if (p.getId() == 0) {
			mergeOnContactIdOrCreate(p, db);
		} else {
			// TODO Ensure if exist ?
		}

	}

	private void mergeOnContactIdOrCreate(Player p, SQLiteDatabase db) {
		long id = findPlayerIdByContactId(p, db);
		if (id > 0) {

			p.setId(id);
		}
		save(p, db);

	}

	private long findPlayerIdByContactId(Player p, SQLiteDatabase db) {
		Cursor c =null;
		long id=0;
		try{
		c=db.query(TABLE_NAME, new String[] { KEY_ID }, KEY_CONTACT_ID
				+ "=? ", new String[] { "" + p.getContactId() }, null, null,
				null);

		if (c.getCount() == 0) {
			id = 0;
		} else {
			if (c.getCount() > 1) {
				throw new RuntimeException("Cas pas encore géré");
			} else {
				c.moveToFirst();
				id = c.getLong(0);

			}
		}
		}catch(Throwable e){
			Log.w(TAG,e.getMessage());
		}
		c.close();
		return id;
	}

	private long save(Player p, SQLiteDatabase db) {
		long key ;
		if(p.getId()==0){
			key= db.insertOrThrow(TABLE_NAME, KEY_ID, getContentValues(p));
		}else{
			key= db.update(TABLE_NAME, getContentValues(p),KEY_ID+"=?",new String[]{""+p.getId()});
		}
		p.setId(key);
		return key;
	}

	private ContentValues getContentValues(Player p) {
		// TODO Auto-generated method stub
		ContentValues c = new ContentValues();
		//if (p.getId() > 0) {
		//	c.put(KEY_ID, p.getId());
		//}
		c.put(KEY_CONTACT_ID, p.getContactId());
		c.put(KEY_CONTACT_URI, p.getContactUri().toString());
		c.put(KEY_NAME, p.getName());
		return c;

	}

	public Player load(long pid, SQLiteDatabase db) {
		Player p = new Player();
		Cursor c =null;
		try{
		c=db.query(TABLE_NAME, new String[] { KEY_ID, KEY_NAME,
				KEY_CONTACT_ID, KEY_CONTACT_URI }, KEY_ID + "=?",
				new String[] { "" + pid }, null, null, null);
		c.moveToFirst();
		p.setId(c.getLong(0));
		p.setName(c.getString(1));
		p.setContactId(c.getLong(2));
		p.setContactUri(Uri.parse(c.getString(3)));
		}catch(Throwable e){
			Log.w(TAG, e.getMessage());
		}finally{
			if(c!=null){
				c.close();
			}
		}
		return p;

	}
}
