package com.example.lab2adnwk.lab8;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab2adnwk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lab8firebas extends AppCompatActivity {
    FirebaseAuth auth;
Button btn_reg_firebase;
EditText txtname,txtpass;
TextView tvkq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8firebas);
        auth = FirebaseAuth.getInstance();
        txtname = findViewById(R.id.l8_edt_name);
        txtpass = findViewById(R.id.l8_edt_pass);
        tvkq = findViewById(R.id.l8_tv_kq);
    }

    public void registerFB(View view) {
        String u = txtname.getText().toString();
        String p= txtpass.getText().toString();
        auth.createUserWithEmailAndPassword(u,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isComplete())
                {

                    tvkq.setText("Thành công");
                }
            }
        });
    }

    public void Loginfirebase(View view) {
        String u = txtname.getText().toString();
        String p= txtpass.getText().toString();
        auth.signInWithEmailAndPassword(u,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {

                    tvkq.setText("Đăng nhập Thành công");
                }
            }
        });
    }

    public  void insertArray(View view)
    {
  String[] ar = new String[]{"Item1","Item2","Item3"};
      Task<Void> df = FirebaseDatabase.getInstance().getReference().child("tiktok").setValue(Arrays.asList(ar));



    }
    public  void  insert_append(View view){
 FirebaseDatabase.getInstance().getReference().child("tiktok").child("Item1").runTransaction(new Transaction.Handler() {
     @NonNull
     @Override
     public Transaction.Result doTransaction(@NonNull MutableData currentData) {
         String lastkey="-1";
         for (MutableData c :currentData.getChildren())
         {

             lastkey=c.getKey();
         }
         int nextkey=Integer.parseInt(lastkey)+1;
         currentData.child(""+nextkey).setValue("giá trị mới");
         return Transaction.success(currentData);


     }

     @Override
     public void onComplete(@Nullable DatabaseError error, boolean committed, @Nullable DataSnapshot currentData) {
         tvkq.setText("insert Thành công");
     }
 });

    }
}