package com.example.microtree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage2 extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage2);

        ImageButton bt_userpage = findViewById(R.id.h2b1);
        ImageButton bt_profile = findViewById(R.id.h2b2);
        ImageButton bt_upload = findViewById(R.id.h2b3);
        ImageButton bt_off = findViewById(R.id.h2b4);

        Intent it = getIntent();
        final String usern = it.getStringExtra("usern");

        bt_userpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Homepage2.this, Userpage2.class);
                a.putExtra("usern",usern);
                startActivity(a);
            }
        });
        bt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Homepage2.this, Profile.class);
                startActivity(a);
            }
        });
        bt_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
