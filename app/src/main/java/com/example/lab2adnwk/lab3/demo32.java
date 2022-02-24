package com.example.lab2adnwk.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2adnwk.R;

import org.w3c.dom.Text;

public class demo32 extends AppCompatActivity implements View.OnClickListener{
    public static final String SEVER_LINK= "https://batdongsanabc.000webhostapp.com/mob403/demo2_api_post.php";
TextView txtkq;
EditText txtcanh;
Button btnpost;
String strCanh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo32);
        txtcanh = findViewById(R.id.txtcanh);
        txtkq = findViewById(R.id.txtkq2);
        btnpost = findViewById(R.id.btnpost);
        btnpost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
     strCanh= txtcanh.getText().toString();
     demo32Asyntack demo32Asyntack = new demo32Asyntack(this,txtkq,strCanh);
     demo32Asyntack.execute();
    }



}