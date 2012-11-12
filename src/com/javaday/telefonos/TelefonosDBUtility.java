package com.javaday.telefonos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TelefonosDBUtility {
	
	private static final String DB_NAME = "Telefonos";
	private static final int DB_VER = 1;
	
	public static final String TBL_NAME = "telefono";
	public static final String FLD_ID = "_id";
	public static final String FLD_NOM = "nombre";
	public static final String FLD_TEL = "telefono";
	public static final String FLD_CORR = "correo";
	
	private DBHelper conn;
	
	public TelefonosDBUtility(Context ctx) {
		conn = new DBHelper(ctx);
	}
	
	public Cursor getContactos () {
		String selectQuery = "Select * from " + TBL_NAME;
		SQLiteDatabase db = conn.getWritableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);
		return c;
	}
	public void insertContacto (String nombre, String correo, String telefono) {
		String insertQuery = "INSERT INTO " +TBL_NAME + "("+ FLD_NOM + "," + FLD_CORR +
				"," + FLD_TEL + ") VALUES ('" + nombre + "','" + correo + "','" + telefono +
				"')";
		SQLiteDatabase db = conn.getWritableDatabase();
		db.execSQL(insertQuery);
				
	}
	class DBHelper extends SQLiteOpenHelper {

		public DBHelper(Context context) {
			super(context, DB_NAME, null, DB_VER);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			String hilera = "CREATE TABLE " + TBL_NAME + " (" + FLD_ID +
					" INTEGER PRIMARY KEY AUTOINCREMENT," + FLD_NOM + " TEXT," +
					FLD_TEL + " TEXT, " + FLD_CORR + " TEXT)";
			db.execSQL(hilera);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
