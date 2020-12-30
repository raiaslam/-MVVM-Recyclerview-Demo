package com.aslam.androidrecyclerviewdemo.model;



import androidx.lifecycle.MutableLiveData;

import com.aslam.androidrecyclerviewdemo.network.RetrofitClient;
import com.aslam.androidrecyclerviewdemo.network.UserDataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {


    /////////// Declare User List for Date   /////////////////////

    private static final String TAG = "UserRepository";
    private ArrayList<User> userArrayList = new ArrayList<>();

    /////////// Declare MutableLiveData for User  List of  Date   /////////////////////

    private MutableLiveData<List<User>> mutableLiveData = new MutableLiveData<>();




    ///////////  Empty Constructor   /////////////////////

    public UserRepository()
    {

    }


    ///////////  Get Data From Api / Live data  & set to Mutable Live Data    /////////////////////

    public MutableLiveData<List<User>> getMutableLiveData() {
        final UserDataService userDataService = RetrofitClient.getService();
        Call<UserServerResponseModel> call = userDataService.getUser();
        call.enqueue(new Callback<UserServerResponseModel>() {
            @Override
            public void onResponse(Call<UserServerResponseModel> call, Response<UserServerResponseModel> response) {
                UserServerResponseModel userdataresponse = response.body();
                if (userdataresponse != null && userdataresponse.getEmployee() != null) {
                    userArrayList = (ArrayList<User>) userdataresponse.getEmployee();
                    mutableLiveData.setValue(userArrayList);
                }
            }
            @Override
            public void onFailure(Call<UserServerResponseModel> call, Throwable t) {
            }
        });
        return mutableLiveData;
    }

}
