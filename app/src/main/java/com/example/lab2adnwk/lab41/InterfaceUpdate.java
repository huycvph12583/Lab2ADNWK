package com.example.lab2adnwk.lab41;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface InterfaceUpdate {
    @FormUrlEncoded
    @POST("api_update.php")
    Call<ResponUpdate> updateExel(


            @Field("pid") String pid,
            @Field("name") String name,
            @Field("price") String price,
            @Field("description") String description
    );
}
