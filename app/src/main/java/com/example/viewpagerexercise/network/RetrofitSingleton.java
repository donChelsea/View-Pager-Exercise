package com.example.viewpagerexercise.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private Retrofit instance;

    public RetrofitSingleton() {
    }

    public Retrofit newInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
