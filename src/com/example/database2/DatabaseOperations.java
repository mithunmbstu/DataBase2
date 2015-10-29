package com.example.database2;

import com.example.database2.TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOperations extends SQLiteOpenHelper {
	
	public static final int database_version = 1;
	public String CREATE_QUERY = "CREATE TABLE "+TableInfo.TABLE_NAME+"("+TableInfo.USER_NAME+" TEXT,"+TableInfo.USER_PASS+" TEXT );";

	public DatabaseOperations(Context context) {
		super(context, TableInfo.DATABASE_NAME, null, database_version);
		Log.d("Database Operations", "Database created");
	}

	@Override
	public void onCreate(SQLiteDatabase sdb) {
		
		sdb.execSQL(CREATE_QUERY);
		Log.d("Database Operations", "Table Created");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	public void putInformation(DatabaseOperations dop, String name,String pass)
	{
		 SQLiteDatabase SQ = dop.getWritableDatabase();
		 ContentValues cv = new ContentValues();
		 cv.put(TableInfo.USER_NAME, name);
		 cv.put(TableInfo.USER_PASS, pass);
		 
		 long k= SQ.insert(TableInfo.TABLE_NAME, null, cv);
		 
		 Log.d("Database Operations", "One row inserted");
		 
	}
	
	public Cursor getInformation(DatabaseOperations dop)
	{
		SQLiteDatabase SQ = dop.getReadableDatabase();
		String[] columns = {TableInfo.USER_NAME,TableInfo.USER_PASS};
		Cursor CR = SQ.query(TableInfo.TABLE_NAME, columns, null, null, null, null, null);
		return CR;
		
		
	}

}
