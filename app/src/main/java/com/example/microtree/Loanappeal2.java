package com.example.microtree;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Loanappeal2 extends AppCompatActivity {
    SQLiteDatabase db;
    MyDBHelper myDB = new MyDBHelper(this);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loanappeal2);
        Button bt_edit = findViewById(R.id.button3);

        Intent it = getIntent();
        String name = it.getStringExtra("usern");

        TextView tv13 = findViewById(R.id.textView13);
        tv13.setText((myDB.displayfullname(name)));

        TextView tv14 = findViewById(R.id.textView14);
        tv14.setText((myDB.displaysource(name)));

        TextView tv15 = findViewById(R.id.textView15);
        tv15.setText((myDB.borrowedmoney(name)));

        TextView tv16 = findViewById(R.id.textView16);
        tv16.setText((myDB.displayreason(name)));

        TextView tv17 = findViewById(R.id.textView17);
        tv17.setText((myDB.displaydate(name)));


        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Loanappeal2.this, Loanappeal.class);
                startActivity(a);
            }
        });
    }
}