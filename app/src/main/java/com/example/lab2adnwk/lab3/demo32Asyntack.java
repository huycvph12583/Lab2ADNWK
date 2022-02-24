package com.example.lab2adnwk.lab3;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class demo32Asyntack extends AsyncTask<Void,Void,Void> {
    String path = demo32.SEVER_LINK;
    Context context;
    TextView tvResult;
    String strCanh;
    String kq="";
    public demo32Asyntack(Context context, TextView tvResult, String strCanh)
    {

this.context= context;
this.tvResult = tvResult;
this.strCanh= strCanh;




    }
    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url = new URL(path);//lấy đường dẫn
            String sparam= "canh="+ URLEncoder.encode(strCanh,"utf-8");//truyền gia trị cạnh
            HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
            // set thuộc tính cho tham so post
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            //4.độ dài thuocj tính
            urlConnection.setFixedLengthStreamingMode(sparam.getBytes().length);
            //5.kieu thuộc tính
            urlConnection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(sparam);
            printWriter.close();
            String line= "";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
       //Biến lưu dữ liệu
            StringBuilder stringBuilder = new StringBuilder();
            while ((line= bufferedReader.readLine())!=null)
            {

                stringBuilder.append(line);

            }
            kq=stringBuilder.toString();
            urlConnection.disconnect();


        } catch (Exception e) {
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
