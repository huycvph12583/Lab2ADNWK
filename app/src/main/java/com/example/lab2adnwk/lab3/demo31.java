package com.example.lab2adnwk.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2adnwk.R;

public class demo31 extends AppCompatActivity implements View.OnClickListener{
    public static final String SEVER_LINK= "https://batdongsanabc.000webhostapp.com/mob403/demo2_api_get.php";
EditText txtname,txtpass;
Button btnget;
TextView txtkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo31);
        txtname= findViewById(R.id.txtname);
        txtpass = findViewById(R.id.txtpass);
        txtkq = findViewById(R.id.txtkq);
        btnget = findViewById(R.id.btnget);
        btnget.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
String strName = txtname.getText().toString();
String strPass = txtpass.getText().toString();
demo31Asyntack demo31Asyntack1 = new demo31Asyntack(this,txtkq,strName,strPass);
demo31Asyntack1.execute();
    }
}