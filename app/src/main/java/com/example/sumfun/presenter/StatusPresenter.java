package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.StatusActivity;

public class StatusPresenter {
    private StatusActivity statusActivity;
    private User user;


    public StatusPresenter(StatusActivity statusActivity){
        this.statusActivity=statusActivity;
    }

    //activate game
    public void activateStarCount(){
        //display correct things on screen
        Log.d("logD", "activateMenu: ");
        statusActivity.displayToast("You have "+user.getStarCount()+ "stars!");
    }
}

