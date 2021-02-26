package com.example.sumfun.model;

import com.example.sumfun.presenter.Presenter;

public class User {
    private int currentLevel;
    private int count;
    private String operator;
    private int starCount;
    private Presenter presenter;

    public User(){}

    public User(Presenter presenter){
        this.presenter=presenter;
    }
    public void saveUser(){

    }
    public void loadUser(){

    }
}
