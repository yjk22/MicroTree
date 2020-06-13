package com.example.microtree;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Userpage2 extends AppCompatActivity {
    SQLiteDatabase db;
    MyDBHelper myDB = new MyDBHelper(this);

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userpage2);

        Intent it = getIntent();
        String usern = it.getStringExtra("usern");

        TextView tv27 = findViewById(R.id.textView27);
        tv27.setText(Integer.toString(myDB.totalmoney(usern)));

        TextView tv29 = findViewById(R.id.textView29);
        tv29.setText(Integer.toString(myDB.paybackamount(usern)));
    }
}