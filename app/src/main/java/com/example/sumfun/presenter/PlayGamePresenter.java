package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.PlayGameActivity;

public class PlayGamePresenter {
    private PlayGameActivity playGameActivity;
    private User user;
    int randomInt=(int)(Math.random()*10);

    public PlayGamePresenter(PlayGameActivity playGameActivity){
        this.playGameActivity=playGameActivity;
    }

    public void saveData(User user){
        user.saveUser(user);
    }
    //activate game
    public void activateGame(){
        //display correct things on screen
        Log.d("logD", "activateMenu: ");
        playGameActivity.displayToast("Let's begin at level "+user.getCurrentLevel());
    }
    public void submitEquation(){

    }
    public void checkResponse(){

    }




}
