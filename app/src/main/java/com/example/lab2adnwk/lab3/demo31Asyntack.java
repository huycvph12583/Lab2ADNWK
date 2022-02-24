package com.example.lab2adnwk.lab3;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.MalformedParametersException;
import java.net.MalformedURLException;
import java.net.URL;

public class demo31Asyntack extends AsyncTask<Void,Void,Void> {
    String path = demo31.SEVER_LINK;
    Context context;
    TextView tvResult;
    String strName,strMark;
    String kq="";
    public demo31Asyntack(Context context, TextView tvResult,String strName,String strMark)
    {

this.context= context;
this.tvResult = tvResult;
this.strName = strName;
this.strMark = strMark;



    }
    @Override
    protected Void doInBackground(Void... voids) {
        path+="?name="+this.strName+"&mark="+this.strMark;
        try {
            URL url = new URL(path);//lấy đường dẫn
            // Tạo Bộ lọc
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream()));
String line= "";//Biến lưu dữ liệu
            StringBuilder stringBuilder = new StringBuilder();
            while ((line= bufferedReader.readLine())!=null)
            {

stringBuilder.append(line);

            }
            kq=stringBuilder.toString();


        } catch (MalformedURLException e) {
            kq=e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            kq=e.getMessage();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        tvResult.setText(kq);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
