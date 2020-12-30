package com.aslam.androidrecyclerviewdemo;






import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aslam.androidrecyclerviewdemo.model.User;
import com.aslam.androidrecyclerviewdemo.adapter.UserDataAdapter;
import com.aslam.androidrecyclerviewdemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ///////////  Declare Adapter & MainView model      /////////////////////

    private  MainViewModel mainViewModel;
    private UserDataAdapter userDataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //////// Set Layout through data binding  //////////////////////

        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //////// Bind Recyclerview //////////////////////

        RecyclerView recyclerView = mainBinding.viewUser;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);



        //////// Set Adapter to recyclerview  //////////////////////

        userDataAdapter = new UserDataAdapter();
        recyclerView.setAdapter(userDataAdapter);

        //////// Function that get Data from Main Model & set to Adapter  //////////////////////

        getAllUser();
    }


    //////// Function that get Data from Main Model & set to Adapter  //////////////////////

    private void getAllUser() {
        mainViewModel.getAllUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                userDataAdapter.setUserList((ArrayList<User>) users);
            }
        });
    }
}