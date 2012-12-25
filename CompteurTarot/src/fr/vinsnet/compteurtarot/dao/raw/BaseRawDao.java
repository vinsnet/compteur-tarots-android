/*******************************************************************************
 * Copyright (c) 2012 vinsnet<vinsnet@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     vinsnet<vinsnet@gmail.com> - initial API and implementation
 ******************************************************************************/
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
	

	protected static final String KEY_ID = "id";

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
