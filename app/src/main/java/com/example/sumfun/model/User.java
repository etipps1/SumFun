package com.example.sumfun.model;

import android.util.Log;


/**
 * public class User
 * currentLevel, count, starCount, countCorrect, currentStage ints
 * operator string
 * purpose: data object for player
 * methods saveUser, loadUser and getter/setters
 */


public class User {
    private int currentLevel =1;
    private int count=0;
    private String operator="+";
    private int starCount=0;
    private int countCorrect=0;
    private int currentStage=1;


    public User(){}

    public void saveUser(User u){
        Log.d("logD", "saveUser:inside ");
        FileHelper fH= new FileHelper(u);
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

    public int getCountCorrect() {
        return countCorrect;
    }

    public void setCountCorrect(int countCorrect) {
        this.countCorrect = countCorrect;
    }
    public int getCurrentStage() {
        return currentStage;
    }
    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

}
