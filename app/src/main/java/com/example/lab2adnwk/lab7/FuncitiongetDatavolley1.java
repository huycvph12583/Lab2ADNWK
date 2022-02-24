package com.example.lab2adnwk.lab7;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FuncitiongetDatavolley1 {
    public  void  fn_deltele_POST(Context context, TextView textView,EditText pid){
        //1 Tạo request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2 Tạo url
        String url ="https://sugarlink1.000webhostapp.com/MOB403/api_delete.php";
        //3 Truyền tham so

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response.toString());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> mydata = new HashMap<>();
                mydata.put("pid",pid.getText().toString());
                return mydata;
            }
        }

                ;
        queue.add(stringRequest);
        //4 Xu Lý reques
    }
    public  void  fn_creat_POST (Context context, TextView textView,EditText pid, EditText name,EditText price,EditText Des){
        //1 Tạo request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2 Tạo url
        String url ="https://sugarlink1.000webhostapp.com/MOB403/api_inten.php";
        //3 Truyền tham so

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText(response.toString());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> mydata = new HashMap<>();
                mydata.put("pid",pid.getText().toString());
                mydata.put("name",name.getText().toString());
                mydata.put("price",price.getText().toString());
                mydata.put("description",Des.getText().toString());


                return mydata;
            }
        }

                ;
        queue.add(stringRequest);
        //4 Xu Lý reques
    }

    public void fn_update_POST(Context context, TextView textView, EditText txtId, EditText txtName, EditText txtPrice, EditText txtDes)
    {
        //1. Tao request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2. url
        String url = "https://sugarlink1.000webhostapp.com/MOB403/api_update.php";
        //3. Truyen tham so
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String,String> mydata = new HashMap<>();
                mydata.put("pid",txtId.getText().toString());
                mydata.put("name",txtName.getText().toString());
                mydata.put("price",txtPrice.getText().toString());
                mydata.put("description",txtDes.getText().toString());
                return mydata;
            }
        };
        //4. Xu ly request
        queue.add(stringRequest);
    }


}
