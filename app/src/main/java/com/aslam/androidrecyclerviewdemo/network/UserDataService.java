package com.aslam.androidrecyclerviewdemo.network;

import com.aslam.androidrecyclerviewdemo.model.UserServerResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserDataService {

    ///////////    Function that contain url of Api     /////////////////////

    @GET("users/?per_page=12&page=1")
    Call<UserServerResponseModel>getUser();

}
