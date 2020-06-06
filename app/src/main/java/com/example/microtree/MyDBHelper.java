package com.example.microtree;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHelper extends SQLiteOpenHelper {
    Context context;
    public int reS;

    public MyDBHelper(Context context) {
        super(context, "mydb.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        String sql;
        sql = "CREATE TABLE donee (username TEXT PRIMARY KEY, name TEXT, phone TEXT, password TEXT)";
        db.execSQL(sql);
        sql = "CREATE TABLE donor (username TEXT PRIMARY KEY, name TEXT, phone TEXT, password TEXT)";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

    }

    public void insertDonee(String username, String name, String phone, String password) {
        SQLiteDatabase db = getWritableDatabase();
        String sql;
        sql = "INSERT INTO donee VALUES('"+username+"','"+name+"','"+phone+"', '"+password+"');";
        db.execSQL(sql);
        db.close();
    }

    public void insertDonor(String username, String name, String phone, String password) {
        SQLiteDatabase db = getWritableDatabase();
        String sql;
        sql = "INSERT INTO donor VALUES('"+username+"','"+name+"','"+phone+"', '"+password+"');";
        db.execSQL(sql);
        db.close();
    }

    public boolean searchDonee(String username){
        SQLiteDatabase db = getReadableDatabase();
        boolean res = false;
        Cursor cursor = db.rawQuery("SELECT username FROM donee", null);
        while(cursor.moveToNext()){
            if(username == cursor.getString(0)){
                res = true;
            }
        }
        return res;
    }

    public boolean searchDonor(String username){
        SQLiteDatabase db = getReadableDatabase();
        boolean res = false;
        Cursor cursor = db.rawQuery("SELECT username FROM donor", null);
        while(cursor.moveToNext()){
            if(username.equals(cursor.getString(0))) {
                res = true;
            }
        }
        return res;
    }


}