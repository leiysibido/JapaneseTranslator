package database;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String DB_NAME = "JPT.db";
    public static final int DB_VERSION = 1;

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String USER_TABLE = "CREATE TABLE" + Gamit.UserWord.TABLE_NAME+" ( "+
                Gamit.UserWord.COL_ENGLISH+"NULL,"+
                Gamit.UserWord.COL_JAPANESE+"NULL )";

        db.execSQL((USER_TABLE));

    }

    public boolean addWord(String Eng, String Jpn){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Gamit.UserWord.COL_ENGLISH, Eng);
        values.put(Gamit.UserWord.COL_JAPANESE, Jpn);

        long sid = db.insert(Gamit.UserWord.TABLE_NAME, null,values);

        if (sid>0)
            return true;
        else
            return false;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

