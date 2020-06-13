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
        sql = "CREATE TABLE donee (username TEXT PRIMARY KEY, name TEXT, phone TEXT, password TEXT, money INTEGER, moneyleft INTEGER)";
        db.execSQL(sql);
        sql = "CREATE TABLE donor (username TEXT PRIMARY KEY, name TEXT, phone TEXT, password TEXT, money INTEGER, moneyleft INTEGER)";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

    }

    public void insertDonee(String username, String name, String phone, String password) {
        SQLiteDatabase db = getWritableDatabase();
        String sql;
        sql = "INSERT INTO donee VALUES('"+username+"','"+name+"','"+phone+"', '"+password+"', 0, 0);";
        db.execSQL(sql);
        db.close();
    }

    public void insertDonor(String username, String name, String phone, String password) {
        SQLiteDatabase db = getWritableDatabase();
        String sql;
        sql = "INSERT INTO donor VALUES('"+username+"','"+name+"','"+phone+"', '"+password+"', 0, 0);";
        db.execSQL(sql);
        db.close();
    }

    public boolean searchDonee(String username, String password){
        SQLiteDatabase db = getReadableDatabase();
        boolean res = false;
        Cursor cursor = db.rawQuery("SELECT username, password FROM donee", null);
        while(cursor.moveToNext()){
            if(username.equals(cursor.getString(0)) && password.equals(cursor.getString(1))){
                res = true;
            }
        }
        return res;
    }

    public int borrowedmoney (String username){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username, money FROM donee", null);
        int mon = 0;
        while(cursor.moveToNext()){
            if(username.equals(cursor.getString(0))){
                mon = cursor.getInt(1);
            }
        }
        return mon;
    }

    public int paybackamount (String username){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username, moneyleft FROM donee", null);
        int mon = 0;
        while(cursor.moveToNext()){
            if(username.equals(cursor.getString(0))){
                mon = cursor.getInt(1);
            }
        }
        return mon;
    }

    public int totalmoney (String username){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username, money FROM donor", null);
        int mon = 0;
        while(cursor.moveToNext()){
            if(username.equals(cursor.getString(0))){
                mon = cursor.getInt(1);
            }
        }
        return mon;
    }

    public int getmoney (String username){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username, moneyleft FROM donor", null);
        int mon = 0;
        while(cursor.moveToNext()){
            if(username.equals(cursor.getString(0))){
                mon = cursor.getInt(1);

            }
        }
        return mon;
    }

    public boolean searchDonor(String username, String password){
        SQLiteDatabase db = getReadableDatabase();
        boolean res = false;
        Cursor cursor = db.rawQuery("SELECT username, password FROM donor", null);
        while(cursor.moveToNext()){
            if(username.equals(cursor.getString(0)) && password.equals(cursor.getString(1))){
                res = true;
            }
        }
        return res;
    }


}