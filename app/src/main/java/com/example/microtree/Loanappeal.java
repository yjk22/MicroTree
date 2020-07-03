package com.example.microtree;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Loanappeal extends AppCompatActivity {
    SQLiteDatabase db;
    MyDBHelper myDB = new MyDBHelper(this);
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loanappeal);

        Intent it = getIntent();
        final String name = it.getStringExtra("usern");

        Button bt_done = findViewById(R.id.button4);
        final TextInputEditText et1 = findViewById(R.id.input1);

        bt_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDB.updatefullname(et1.getText().toString(),name);
                Intent a = new Intent(Loanappeal.this, Loanappeal2.class);
                a.putExtra("name",name);
                startActivity(a);
                finish();
            }
        });
    }
}