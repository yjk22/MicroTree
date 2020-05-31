package com.example.microtree;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Register extends AppCompatActivity {

    SQLiteDatabase db;
    DoneeDBHelper doneeDB = new DoneeDBHelper(this);
    DonorDBHelper donorDB = new DonorDBHelper(this);


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button insert = findViewById(R.id.button);
        final CheckBox donor = findViewById(R.id.checkBox);
        final TextInputEditText userName = findViewById(R.id.input5);
        final TextInputEditText Name = findViewById(R.id.input6);
        final TextInputEditText Phone = findViewById(R.id.input7);
        final TextInputEditText Password = findViewById(R.id.input8);


        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String username = userName.getText().toString();
                String name = Name.getText().toString();
                String phone = Phone.getText().toString();
                String password = Password.getText().toString();
                if (donor.isChecked()){
                    donorDB.insert(username, name, phone, password);
                }
                else{
                    doneeDB.insert(username, name, phone, password);
                }
            }
        });
    }
}