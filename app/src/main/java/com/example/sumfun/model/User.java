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
        //load default if no file
        Log.d("logD", "loadUser: ");
        FileHelper.loadUser();
        Log.d("logD", "in loadUser");

    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
