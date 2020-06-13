package com.example.microtree;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Userpage extends AppCompatActivity {
    SQLiteDatabase db;
    MyDBHelper myDB = new MyDBHelper(this);

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userpage);

        Intent it = getIntent();
        String usern = it.getStringExtra("usern");

        TextView tv21 = findViewById(R.id.textView21);
        tv21.setText(Integer.toString(myDB.borrowedmoney(usern)));

        TextView tv23 = findViewById(R.id.textView23);
        tv23.setText(Integer.toString(myDB.paybackamount(usern)));
    }
}