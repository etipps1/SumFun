package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.PlayGameActivity;

/**
 * public class PlayGamePresenter
 * purpose: controller for PlayGameActivity
 */
public class PlayGamePresenter {
    private PlayGameActivity playGameActivity;
    private User user;
    int randomInt;
    int countLoop;
    int currentLevel;
    String op;
    int starCount;
    int countCorrect;
    int currentStage;


    public PlayGamePresenter(PlayGameActivity playGameActivity) {
        this.playGameActivity = playGameActivity;
        user = new User();
        user.loadUser();
        countLoop = user.getCount();
        currentLevel = user.getCurrentLevel();
        op = user.getOperator();
        starCount = user.getStarCount();
        countCorrect = user.getCountCorrect();
        currentStage=user.getCurrentStage();
    }

    /**
     * public method saveData
     * passes user object to user saveUser method
     */

    public void saveData() {
        user.setCount(countLoop);
        user.setCurrentLevel(currentLevel);
        user.setOperator(op);
        user.setStarCount(starCount);
        user.setCountCorrect(countCorrect);
        user.setCurrentStage(currentStage);
        Log.d("logD", "saveData:inside ");
        user.saveUser(this.user);
    }

    /**
     * begins game with toast of current user level for addition
     */
    //activate game
    public void activateGame() {
        //display correct things on screen
        Log.d("logD", "activateMenu: ");
        playGameActivity.displayToast("Let's begin at level " + user.getCurrentLevel());
    }

    /**
     * public method submitEquation
     * purpose: send currentLevel as first number, operator, and randomInt as second number of equation
     */
    public void submitEquation() {
        randomInt = (int) (Math.random() * 10);
        playGameActivity.showEquation(currentLevel, op, randomInt);

    }

    /**
     * public method checkResponse
     * @param second int
     * @param response string
     *  purpose: checks response to verify not blank and if blank sends toast prompt
     *  parses response, creates new instance of Addition class
     *  gets correct or wrong toast from addLevel method of Addition class
     *  displays toast message
     *  updates countLoop and countCorrect
     *  checks for next stage
     *  clears equation values
     */
    public void checkResponse(int second, String response) {
        //checking for empty response and prompting for a number
        if (response.trim().equals("")) {
            playGameActivity.displayToast("Enter a number");
        } else {
            Log.d("logD", "checkResponse:before else " + countLoop);
            int parsedResponse = Integer.valueOf(response);
            validateResponse(second, parsedResponse);

            /*Addition addition = new Addition(currentLevel, second, parsedResponse, countLoop, countCorrect);
            //get correct or wrong toast message from addLevel();
            String toastText = addition.addLevel();
            //display toast message
            playGameActivity.displayToast(toastText);

            //get correctCount from Addition
            int updatedCount = addition.getCountLoop();
            Log.d("logD", "checkResponse:updatedCount " + updatedCount);
            countLoop = updatedCount;

            int updatedCountCorrect = addition.getCountCorrect();
            Log.d("logD", "checkResponse:countCorrect " + updatedCountCorrect);
            //set localCount to correctCount
            countCorrect = updatedCountCorrect;

            checkCountLoop(countLoop, countCorrect);
            //clears equation values
            playGameActivity.clearText();

             */

        }
    }

    /**
     * public method validateResponse
     * @param second int
     * @param parsedResponse int
     * purpose: substitute for interface to determine which class(level) for mathematical operation
     */
    public void validateResponse(int second, int parsedResponse){

        if (op.equalsIgnoreCase("+")) {
            Addition addition = new Addition(currentLevel, second, parsedResponse, countLoop, countCorrect);
            //get correct or wrong toast message from addLevel();
            String toastText = addition.addLevel();
            //display toast message
            playGameActivity.displayToast(toastText);

            //get correctCount from Addition
            int updatedCount = addition.getCountLoop();
            Log.d("logD", "checkResponse:updatedCount " + updatedCount);
            countLoop = updatedCount;

            int updatedCountCorrect = addition.getCountCorrect();
            Log.d("logD", "checkResponse:countCorrect " + updatedCountCorrect);
            //set localCount to correctCount
            countCorrect = updatedCountCorrect;

            checkCountLoop(countLoop, countCorrect);
            //clears equation values
            playGameActivity.clearText();
        }
        else if (op.equalsIgnoreCase("-")){
            Subtraction subtraction = new Subtraction(currentLevel, second, parsedResponse, countLoop, countCorrect);
            //get correct or wrong toast message from subLevel();
            String toastText = subtraction.subLevel();
            //display toast message
            playGameActivity.displayToast(toastText);

            //get correctCount from Subtraction
            int updatedCount = subtraction.getCountLoop();
            Log.d("logD", "checkResponse:updatedCount " + updatedCount);
            countLoop = updatedCount;

            int updatedCountCorrect = subtraction.getCountCorrect();
            Log.d("logD", "checkResponse:countCorrect " + updatedCountCorrect);
            //set localCount to correctCount
            countCorrect = updatedCountCorrect;

            checkCountLoop(countLoop, countCorrect);
            //clears equation values
            playGameActivity.clearText();

        }


    }

    /**
     * public method checkCountLoop
     * @param cntLoop int
     * @param cntCorrect int
     *  purpose: check countLoop total and if 7 of 10 correct, pass to next level  and display toast
     */
    public void checkCountLoop(int cntLoop, int cntCorrect) {
        if (cntLoop > 10) {

            if (cntCorrect >= 7) {
                currentLevel++;
                starCount++;
                countCorrect=0;
                countLoop=0;
                playGameActivity.displayToast("You passed this level!");
            } else {
                playGameActivity.displayToast("Let's practice more.");
                countCorrect=0;
                countLoop=0;
            }
        }

    }

    /**
     * public method checkLevelLoop
     * check addition level and if greater than 10, move to next stage of subtraction
     */
    public void checkLevelLoop(){
        if (currentLevel>10 && currentLevel<21){
            currentStage=2;
            op="-";

        }

    }

}
