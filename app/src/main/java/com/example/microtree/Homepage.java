package com.example.microtree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        ImageButton bt_userpage = findViewById(R.id.hpbtn1);
        ImageButton bt_appeal = findViewById(R.id.hpbtn2);
        ImageButton bt_service = findViewById(R.id.hpbtn3);
        ImageButton bt_off = findViewById(R.id.hpbtn4);

        Intent it = getIntent();
        final String usern = it.getStringExtra("usern");

        bt_userpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Homepage.this, Userpage.class);
                a.putExtra("usern",usern);
                startActivity(a);

            }
        });
        bt_appeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Homepage.this, Loanappeal2.class);
                a.putExtra("usern",usern);
                startActivity(a);
            }
        });
        bt_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Homepage.this, Advisory.class);
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
