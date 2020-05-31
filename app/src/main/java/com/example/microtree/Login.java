package com.example.microtree;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    DoneeDBHelper doneeDB = new DoneeDBHelper(this);
    DonorDBHelper donorDB = new DonorDBHelper(this);

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final TextInputEditText user = findViewById(R.id.username);
        final TextInputEditText pass = findViewById(R.id.password);
        Button bt_login = findViewById(R.id.button1);
        Button bt_register = findViewById(R.id.button2);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(doneeDB.search(user.getText().toString()) == true || donorDB.search(user.getText().toString()) == true) {
                    Intent a = new Intent(Login.this, Homepage.class);
                    String temp;
                    temp = user.getText().toString();
                    a.putExtra("user",temp);
                    startActivity(a);
                }
            }
        });
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Login.this, Register.class);
                startActivity(a);
            }
        });
    }
}