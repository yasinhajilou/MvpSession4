package com.example.mvpsession4.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit mRetrofit;
    private static String BASE_URL = "https://jsonplaceholder.typicode.com";
     static Retrofit getRetrofit(){
        if (mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
