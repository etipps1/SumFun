package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.PlayGameActivity;

public class PlayGamePresenter {
    private PlayGameActivity playGameActivity;
    private User user;
    int randomInt;
    int count;
    int currentLevel;
    String op;



    public PlayGamePresenter(PlayGameActivity playGameActivity){
        this.playGameActivity=playGameActivity;
        user = new User();
        user.loadUser();
        count= user.getCount();
        currentLevel=user.getCurrentLevel();
        op=user.getOperator();
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
        randomInt=(int)(Math.random()*10);
       playGameActivity.showEquation(currentLevel, op, randomInt);

    }
    public void checkResponse(int second, String response){
        if (response.trim().equals("")) {
            playGameActivity.displayToast("Enter a number");
        }
        else {
            int parsedResponse = Integer.valueOf(response);
            Addition addition= new Addition(currentLevel, second, parsedResponse);
            String toastText = addition.addLevel();
            playGameActivity.displayToast(toastText);

        }

    }




}
