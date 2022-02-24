package com.example.lab2adnwk.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2adnwk.R;

public class lab7activity extends AppCompatActivity {
    EditText txtpid,txtname,txtprice,txtdes;
    Button btnadd,btnup,btndel,btnsel;
    FuncitiongetDatavolley1 fn ;

    TextView txtkq ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7activity);
fn = new FuncitiongetDatavolley1();
        txtpid = findViewById(R.id.l7_edt_pid);
        txtname = findViewById(R.id.l7_edt_name);
        txtprice = findViewById(R.id.l7_edt_price);
        txtdes = findViewById(R.id.l7_edt_des);
        btndel = findViewById(R.id.btn_delete);
        btnadd = findViewById(R.id.btn_add);
        btnup = findViewById(R.id.btn_update);
        btnsel = findViewById(R.id.btn_select);
        txtkq = findViewById(R.id.l7_txt_kq);
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    fn.fn_deltele_POST(getApplication(),txtkq,txtpid);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fn.fn_creat_POST(getApplication(),txtkq,txtpid,txtname,txtprice,txtdes);
            }
        });

        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fn.fn_update_POST(getApplication(),txtkq,txtpid,txtname,txtprice,txtdes);
            }
        });

    }
}