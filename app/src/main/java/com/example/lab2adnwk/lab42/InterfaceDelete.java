package com.example.lab2adnwk.lab42;

import com.example.lab2adnwk.lab41.ResponUpdate;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceDelete {
    @FormUrlEncoded
    @POST("api_delete.php")
    Call<ResponDelete> deleteExel(


            @Field("pid") String pid

    );
}
