package com.example.lab2adnwk.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lab2adnwk.R;

public class lab6activity extends AppCompatActivity {
 Button btn_getdata;
 TextView tv_getData,tv_getdatajson;
 FuncitiongetDatavolley fn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6activity);
        btn_getdata= findViewById(R.id.l6_btn_getdata);
        tv_getData = findViewById(R.id.l6_tv_getdata);
        tv_getdatajson = findViewById(R.id.l6_tv_json);
        fn = new FuncitiongetDatavolley();
        btn_getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fn.getJSON_ARRAY_OBJ(lab6activity.this,tv_getdatajson);
                fn.getStringVolley(lab6activity.this,tv_getData);

            }
        });

    }
}