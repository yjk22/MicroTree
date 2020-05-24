package com.example.microtree;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TransDBHelper extends SQLiteOpenHelper {
    Context context;

    public TransDBHelper(Context context) {
        super(context, "my.db", null, 1);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        String sql;
        sql = "CREATE TABLE trans (doneeid INTEGER, donorid INTEGER,id INTEGER PRIMARY KEY)";
        db.execSQL(sql);
    }

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {

    }

    public void insert(int doneeid, int donorid) {
        SQLiteDatabase db = getWritableDatabase();
        String sql;
        sql = "INSERT INTO trans VALUES(" + doneeid + "," + donorid + ");";
        db.execSQL(sql);
        db.close();
    }
}