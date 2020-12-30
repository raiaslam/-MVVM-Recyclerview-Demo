package com.aslam.androidrecyclerviewdemo;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.aslam.androidrecyclerviewdemo.model.User;
import com.aslam.androidrecyclerviewdemo.model.UserRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    //////// Declare Class that contain Mutable Live data that get from server   //////////////////////

    private UserRepository userRepository;


    public MainViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository();
    }

    public LiveData<List<User>>getAllUser()
    {
        return userRepository.getMutableLiveData();
    }
}
