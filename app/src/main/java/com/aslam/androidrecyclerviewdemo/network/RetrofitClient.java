package com.aslam.androidrecyclerviewdemo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    ///////////   Class That contain Base url for Api / Live data through retrofit    /////////////////////

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://reqres.in/api/";
    public static UserDataService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(UserDataService.class);
    }
}
