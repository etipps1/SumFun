package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.PlayGameActivity;

public class PlayGamePresenter {
    private PlayGameActivity playGameActivity;
    private User user;
    int randomInt;
    int countLoop;
    int currentLevel;
    String op;
    int starCount;
    int countCorrect;



    public PlayGamePresenter(PlayGameActivity playGameActivity){
        this.playGameActivity=playGameActivity;
        user = new User();
        user.loadUser();
        countLoop= user.getCount();
        currentLevel=user.getCurrentLevel();
        op=user.getOperator();
        starCount=user.getStarCount();
        countCorrect=user.getCountCorrect();
    }

    public void saveData(){
        Log.d("logD", "saveData:inside ");
        user.saveUser(user);
    }


    //activate game
    public void activateGame(){
        //display correct things on screen
        Log.d("logD", "activateMenu: ");
        playGameActivity.displayToast("Let's begin at level "+ user.getCurrentLevel());
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
            Log.d("logD", "checkResponse:before else "+ countLoop);
            int parsedResponse = Integer.valueOf(response);
            Addition addition= new Addition(currentLevel, second, parsedResponse, countLoop,countCorrect);
            String toastText = addition.addLevel();
            //get correctCount from Addition
            int updatedCount = addition.getCountLoop();
            Log.d("logD", "checkResponse:updatedCount "+ updatedCount);
            countLoop=updatedCount;
            Log.d("logD", "checkResponse:countCorrect "+ countCorrect);
            int updatedCountCorrect= addition.getCountCorrect();
            //set localCount to correctCount
            countCorrect=updatedCountCorrect;

            playGameActivity.displayToast(toastText);

        }

    }




}
