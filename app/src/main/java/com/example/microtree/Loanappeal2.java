package com.example.microtree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Loanappeal2 extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loanappeal2);
        Button bt_edit = findViewById(R.id.button3);

        Intent it = getIntent();
        String name = it.getStringExtra("name");

        if (name != null){
            TextView tv = findViewById(R.id.textView13);
            tv.setText(name);
        }

        bt_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(Loanappeal2.this, Loanappeal.class);
                startActivity(a);
            }
        });
    }
}