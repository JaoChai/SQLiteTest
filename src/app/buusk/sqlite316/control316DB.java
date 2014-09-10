package app.buusk.sqlite316;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class control316DB extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "mydata316";
	private static final String TABLE_MEMBER = "members";
	private static final int DATABASE_VERSION = 1;

	public control316DB(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+ "(MemberID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " Name TEXT(100)," + " Tel TEXT(100));");
		// CREATE TABLE member(MemberID INTEGER,Name TEXT(100),Tel TEXT()100);

		Log.d("CREATE TABLE", "Create Table Successfully");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
		onCreate(db);
	}
	//Insert Data
	public long InsertData(String strName, String strTel) {
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("Name", strName);
			values.put("Tel", strTel);
			long l = db.insert(TABLE_MEMBER, null, values);
			db.close();
			return l;
		} catch (Exception e) {
			return -1;
		}
	}

}
