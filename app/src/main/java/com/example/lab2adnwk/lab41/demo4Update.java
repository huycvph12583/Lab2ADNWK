package com.example.lab2adnwk.lab41;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2adnwk.R;
import com.example.lab2adnwk.lab42.FuncitionDelete;

public class demo4Update extends AppCompatActivity {
EditText edpid,edname,edprice,eddes;
Button btnUpdate,btndelete;
TextView tv_err;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo4_update);
        edpid= findViewById(R.id.edt_pid41);
        edname = findViewById(R.id.edt_name41);
        edprice = findViewById(R.id.edt_price41);
        eddes = findViewById(R.id.edt_des41);
        btnUpdate = findViewById(R.id.btn_update41);
        btndelete = findViewById(R.id.btn_delete41);
        tv_err = findViewById(R.id.tv_err);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PrdUpdate p = new PrdUpdate();
                p.setPid(edpid.getText().toString());
                p.setName(edname.getText().toString());
                p.setPrice(edprice.getText().toString());
                p.setDescription(eddes.getText().toString());
                FuncitionUpdate f = new FuncitionUpdate();
                f.updateFn(tv_err,p);
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FuncitionDelete f = new FuncitionDelete();
                f.deleteFn(tv_err,edpid.getText().toString());
            }
        });
    }
}