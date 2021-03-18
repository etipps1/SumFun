package com.example.sumfun.model;

import android.content.Context;
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
    private int currentStage=0;

    /**
     * public constructor for User class
     */
    public User(){}

    /**
     * public method saveUser
     * @param context Context
     * @param u User
     * purpose: receive context an u and pass to FileHelper saveUser2
     */
    public void saveUser(Context context, User u){
    //public void saveUser(User u){
        Log.d("logD", "saveUser:inside ");
        FileHelper fH= new FileHelper(context, u);
        fH.saveUser2();

    }

    /**
     * public method loadUser
     * @param context Context
     * @return User
     * purpose: get newUser from FileHelper loadUser2
     */
    public User loadUser(Context context){
        //load default if no file
        Log.d("logD", "loadUser: ");
        FileHelper fh= new FileHelper(context);
        User newUser = fh.loadUser2();
        Log.d("logD", "in loadUser");
        return newUser;

    }


    /*getters and setters*/

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
