package com.example.sumfun.model;

import android.util.Log;

import com.example.sumfun.presenter.Presenter;

public class User {
    private int currentLevel =1;
    private int count=1;
    private String operator="+";
    private int starCount=0;
    private Presenter presenter;

    public User(){}

    public User(Presenter presenter){
        this.presenter=presenter;
    }
    public void saveUser(User user){
        FileHelper fH= new FileHelper(user);
        fH.saveUser();

    }
    public void loadUser(){
        Log.d("logD", "loadUser: ");
        FileHelper.loadUser();
        Log.d("logD", "in loadUser");

    }
}
