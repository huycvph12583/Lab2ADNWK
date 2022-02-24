package com.example.lab2adnwk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab2adnwk.lab3.demo31;
import com.example.lab2adnwk.lab3.demo32;

public class MainActivity extends AppCompatActivity {
Button btn31,btn32;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn31= findViewById(R.id.btn31);
        btn32 = findViewById(R.id.btn32);
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, demo31.class);
                startActivity(intent);
            }
        });
        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, demo32.class);
                startActivity(intent);
            }
        });
    }
}