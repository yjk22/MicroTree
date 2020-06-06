package com.example.microtree;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    MyDBHelper myDB = new MyDBHelper(this);

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

                if(myDB.searchDonee(user.getText().toString(), pass.getText().toString())) {
                    Intent a = new Intent(Login.this, Homepage.class);
                    String temp;
                    temp = user.getText().toString();
                    a.putExtra("user",temp);
                    startActivity(a);
                }
                else if(myDB.searchDonor(user.getText().toString(), pass.getText().toString())){
                    Intent a = new Intent(Login.this, Homepage2.class);
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