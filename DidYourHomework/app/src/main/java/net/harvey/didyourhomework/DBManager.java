package net.harvey.didyourhomework;

/**
 * Created by junsu on 15. 8. 23.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager extends SQLiteOpenHelper {

    public DBManager(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 새로운 테이블을 생성한다.
        // create table 테이블명 (컬럼명 타입 옵션);
        db.execSQL("CREATE TABLE EVENT_LIST(" +
                " _id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT," +
                " start TEXT," +
                " end TEXT," +
                " detail TEXT," +
                " repeat INTEGER," +
                " test INTEGER," +
                " homework INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insert(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void update(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public void delete(String _query) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(_query);
        db.close();
    }

    public String PrintData() {
        SQLiteDatabase db = getReadableDatabase();
        String str = "";

        Cursor cursor = db.rawQuery("select * from EVENT_LIST", null);
        while(cursor.moveToNext()) {
            str += cursor.getInt(1)
                    + " "
                    + cursor.getString(2)
                    + " ~ "
                    + cursor.getInt(3)
                    + ", detail : "
                    + cursor.getInt(4)
                    + "\n";
        }

        return str;
    }

//    public
}