package com.example.microtree;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DoneeDBHelper extends SQLiteOpenHelper {
    Context context;

    public DoneeDBHelper(Context context) {
        super(context, "my.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        String sql;
        sql = "CREATE TABLE donee (username TEXT PRIMARY KEY, name TEXT, phone TEXT, password TEXT)";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

    }

    public void insert(String username, String name, String phone, String password) {
        SQLiteDatabase db = getWritableDatabase();
        String sql;
        sql = "INSERT INTO donee VALUES('"+username+"','"+name+"','"+phone+"', '"+password+"');";
        db.execSQL(sql);
        db.close();
    }

    public Boolean search(String username){
        SQLiteDatabase db = getReadableDatabase();
        Boolean res = false;

        Cursor cursor = db.rawQuery("SELECT username FROM donee", null);
        while(cursor.moveToNext()){
            if(username == cursor.getString(0)){
                res = true;
            }
        }
        return res;
    }
}