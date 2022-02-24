package com.example.lab2adnwk.lab6;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FuncitiongetDatavolley {
    public  void  getStringVolley(Context context, TextView textView){
        //1 Tạo request
        RequestQueue queue = Volley.newRequestQueue(context);
        //2 Tạo url
        String url ="https://www.google.com/";
        //3 Truyền tham so

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                textView.setText("Kết quả" + response.substring(0, 1000));
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        queue.add(stringRequest);
        //4 Xu Lý reques
    }
    // demo2:dọc du lieu mang cua doi tương
    String stringJson ="";
    public  void getJSON_ARRAY_OBJ(Context context,TextView textView){


        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://sugarlink1.000webhostapp.com/MOB403/api_selectjs.json";

        JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray emlp = response.getJSONArray("employees");
                    for (int i=0;i<emlp.length();i++)
                {

                    try {
                        JSONObject employees = emlp.getJSONObject(i);//lấy về 1 đối tương


                        String id = employees.getString("id");
                        String first_name = employees.getString("first_name");
                        String last_name = employees.getString("last_name");
                        String address = employees.getString("address");
                              stringJson+= "ID :"+id+"\n";
                        stringJson+= "FISRT NAME :"+first_name+"\n";
                        stringJson+= "LASTNAME :"+last_name+"\n";
                        stringJson+= "ANDRESS :"+address+"\n";


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
               textView.setText(stringJson);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                                textView.setText("Lỗi game");

            };
        });
//        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                for (int i=0;i<response.length();i++)
//                {
//
//
////                    try {
////                        JSONObject employees = response.getJSONObject(i);//lấy về 1 đối tương
////
////
////                        String id = employees.getString("id");
////                        String first_name = employees.getString("first_name");
////                        String last_name = employees.getString("last_name");
////                        String address = employees.getString("address");
////                              stringJson+= "ID :"+id+"\n";
////                        stringJson+= "FISRT NAME :"+first_name+"\n";
////                        stringJson+= "LASTNAME :"+last_name+"\n";
////                        stringJson+= "ANDRESS :"+address+"\n";
////                        stringJson+= "ID :"+id+"\n";
////
////                    } catch (JSONException e) {
////                        e.printStackTrace();
////                    }
//                }
//                textView.setText(stringJson);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                textView.setText("Lỗi game");
//            }
//        });
queue.add(request);

    }
}
