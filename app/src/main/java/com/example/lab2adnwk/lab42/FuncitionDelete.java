package com.example.lab2adnwk.lab42;

import android.widget.TextView;

import com.example.lab2adnwk.lab41.ConstUpdate;
import com.example.lab2adnwk.lab41.InterfaceUpdate;
import com.example.lab2adnwk.lab41.PrdUpdate;
import com.example.lab2adnwk.lab41.RequesUpdate;
import com.example.lab2adnwk.lab41.ResponUpdate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FuncitionDelete {
    public  void deleteFn(TextView tvResult, String pid )
    {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(constdelete.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

       PrdDelete p = new PrdDelete();
        p.setPid(pid);
        //Gọi hàm từ INF
        RequesDelete requesDelete = new RequesDelete();
        requesDelete.setProducts(p);
        InterfaceDelete interfaceDelete = retrofit.create(InterfaceDelete.class);
        Call<ResponDelete> call = interfaceDelete.deleteExel(pid);
        call.enqueue(new Callback<ResponDelete>() {
            @Override
            public void onResponse(Call<ResponDelete> call, Response<ResponDelete> response) {
            ResponDelete responDelete = response.body();
                tvResult.setText(responDelete.getMessage());
            }

            @Override
            public void onFailure(Call<ResponDelete> call, Throwable t) {
                tvResult.setText(t.getMessage());
            }
        });


    }
}
