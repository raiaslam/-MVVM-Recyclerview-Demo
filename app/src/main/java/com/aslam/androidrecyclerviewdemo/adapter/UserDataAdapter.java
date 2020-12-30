package com.aslam.androidrecyclerviewdemo.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aslam.androidrecyclerviewdemo.model.User;
import com.aslam.androidrecyclerviewdemo.R;
import com.aslam.androidrecyclerviewdemo.databinding.UserListItemBinding;

import java.util.ArrayList;

public class UserDataAdapter  extends RecyclerView.Adapter<UserDataAdapter.UserViewHolder> {

    /////////// Declare User List /////////////////////

    private ArrayList<User> userArrayList;

    @NonNull
    @Override
    public UserDataAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        /////////// Inflate layout through binding  /////////////////////

        UserListItemBinding userListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.user_list_item,parent,false);
        return  new UserViewHolder(userListItemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull UserDataAdapter.UserViewHolder holder, int position) {


        /////////// Set Data to holder through binding  /////////////////////

        User user = userArrayList.get(position);

        holder.userListItemBinding.setEmployee(user);

    }

    @Override
    public int getItemCount() {

        /////////// Check  User List is empty or not  /////////////////////

        if (userArrayList != null) {
            return userArrayList.size();
        } else {
            return 0;
        }
    }

    /////////// Function that is used to set data to adapter   /////////////////////

    public void setUserList(ArrayList<User> userList) {
        this.userArrayList = userList;
        notifyDataSetChanged();
    }


     class UserViewHolder extends RecyclerView.ViewHolder {

        /////////// Declare Data Model Binding  /////////////////////

        private UserListItemBinding userListItemBinding;

        public UserViewHolder(@NonNull UserListItemBinding userListItemBinding) {
            super(userListItemBinding.getRoot());
            this.userListItemBinding = userListItemBinding;
        }
    }
}
