package com.example.sumfun.presenter;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sumfun.model.User;
import com.example.sumfun.view.StatusActivity;

public class StatusPresenter {
    private StatusActivity statusActivity;
    private User user;






    public StatusPresenter(StatusActivity statusActivity){
        this.statusActivity=statusActivity;
        user = new User();
        user.loadUser();
    }

    public void submitStatusDisplay(){
        statusActivity.showStatusDisplay(user.getStarCount());

    }

    //activate game
    public void activateStarCount(){
        //display correct things on screen
        Log.d("logD", "activateStarCount: ");
        statusActivity.displayToast("You have "+user.getStarCount()+ " stars!");
    }
}

