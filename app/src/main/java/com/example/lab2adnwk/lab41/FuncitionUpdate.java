package com.example.lab2adnwk.lab41;

import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FuncitionUpdate {
    public  void updateFn(TextView tvResult,PrdUpdate p )
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstUpdate.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       RequesUpdate requesUpdate = new RequesUpdate();
        requesUpdate.setProducts(p);
        //Gọi hàm từ INF
        InterfaceUpdate interfaceUpdate = retrofit.create(InterfaceUpdate.class);
        Call<ResponUpdate> call = interfaceUpdate.updateExel(p.getPid(),p.getName(),p.getPrice(),p.getDescription());
        call.enqueue(new Callback<ResponUpdate>() {
            @Override
            public void onResponse(Call<ResponUpdate> call, Response<ResponUpdate> response) {
            ResponUpdate responUpdate = response.body();
                tvResult.setText(responUpdate.getMessage());
            }

            @Override
            public void onFailure(Call<ResponUpdate> call, Throwable t) {
                tvResult.setText(t.getMessage());
            }
        });


    }
}
