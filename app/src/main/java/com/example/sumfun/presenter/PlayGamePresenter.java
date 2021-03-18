package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.PlayGameActivity;

/**
 * public class PlayGamePresenter
 * purpose: controller for PlayGameActivity
 * private PlayGameActivity playGameActivity, User user, MathLevel mL
 * int randomInt, countLoop, currentLevel, starCount, countCorrect, currentStage
 * String op
 * SoundCheck sc, SoundPlayer sp
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
    SoundCheck sc;
    SoundPlayer sp;
    private MathLevel mL;

    /**
     * public PlayGamePresenter constructor
     * @param playGameActivity playGameActivity
     */


    public PlayGamePresenter(PlayGameActivity playGameActivity) {
        this.playGameActivity = playGameActivity;
        user = new User();
        user = user.loadUser(playGameActivity);
        countLoop = user.getCount();
        currentLevel = user.getCurrentLevel();
        op = user.getOperator();
        starCount = user.getStarCount();
        countCorrect = user.getCountCorrect();
        currentStage = user.getCurrentStage();
        this.sc = new SoundCheck(playGameActivity); //this context needs to be called in from this class Pulled from here first
        this.sp = new SoundPlayer(playGameActivity);

    }

    /**
     * public method selectMathLevel
     * @param mL MathLevel
     * purpose: select which MathLevel to use through interface
     * @return void
     */

    public void selectMathLevel(MathLevel mL) {
        this.mL = mL;

    }

    /**
     * public method doMath
     * @return String
     * purpose: returns String toast through interface
     */

    public String doMath() {
        String toastString = mL.doMath();
        return toastString;
    }

    /**
     * public method saveData
     * passes user object to user saveUser method
     * @return void
     */
    public void saveData(PlayGameActivity playGameActivity) {

        user.setCount(countLoop);
        user.setCurrentLevel(currentLevel);
        user.setOperator(op);
        user.setStarCount(starCount);
        user.setCountCorrect(countCorrect);
        user.setCurrentStage(currentStage);
        Log.d("logD", "saveData:inside ");
        user.saveUser(playGameActivity, this.user);
    }

    /**
     * public activateGame
     * begins game with toast of current user level for addition
     * @return void
     */
    //activate game
    public void activateGame() {
        //display correct data on screen
        Log.d("logD", "activateMenu: ");
        playGameActivity.displayToast("Let's begin with " + user.getCurrentLevel());
    }

    /**
     * public method submitEquation
     * purpose: send currentLevel as first number, operator, and randomInt as second number of equation
     * @return void
     */
    public void submitEquation() {
        //randomInt = (int) (Math.random() * 10);
        if (op.equalsIgnoreCase("/")) {
            randomInt = (int) ((Math.random() * 10)) + 1;
            Log.d("logD", "submitEquation: " + randomInt);
            playGameActivity.showEquation((currentLevel * randomInt), op, currentLevel);
        } else {
            randomInt = (int) (Math.random() * 10);
            playGameActivity.showEquation(currentLevel, op, randomInt);
        }

    }

    /**
     * public method checkResponse
     *
     * @param second   int
     * @param response string
     * @return void
     * purpose: checks response to verify not blank and if blank sends toast prompt
     * parses response, creates new instance of Addition class
     * gets correct or wrong toast from addLevel method of Addition class
     * displays toast message
     * updates countLoop and countCorrect
     * checks for next stage
     * clears equation values
     */
    public void checkResponse(int second, String response, int first) {
        //checking for empty response and prompting for a number
        if (response.trim().equals("")) {
            playGameActivity.displayToast("Enter a number");
        } else {
            Log.d("logD", "checkResponse:before else " + countLoop);
            int parsedResponse = Integer.valueOf(response);
            validateResponse(second, parsedResponse, first);
            checkLevelLoop();

            /*//moved to validateResponse();
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

             */

        }
    }

    /**
     * public method validateResponse
     *
     * @param second         int
     * @param parsedResponse int
     * @return void
     * purpose: use interface to determine which class(level) for mathematical operation
     * return text for toast & sound, update countLoop & countCorrect, and clearText()
     */
    public void validateResponse(int second, int parsedResponse, int first) {

        if (op.equalsIgnoreCase("+")) {
            selectMathLevel(new Addition(currentLevel, second, parsedResponse, countLoop, countCorrect));
        } else if (op.equalsIgnoreCase("-")) {
            selectMathLevel(new Subtraction(currentLevel, second, parsedResponse, countLoop, countCorrect));
        } else if (op.equalsIgnoreCase("*")) {
            selectMathLevel(new Multiplication(currentLevel, second, parsedResponse, countLoop, countCorrect));
        } else if (op.equalsIgnoreCase("/")) {
            selectMathLevel(new Division(currentLevel, second, parsedResponse, countLoop, countCorrect, first));
        }
        String toastText = mL.doMath();
        playGameActivity.displayToast(toastText);
        sc.soundCheck(toastText);
        int updatedCount = mL.getCountLoop();
        Log.d("logD", "checkResponse:updatedCount " + updatedCount);
        countLoop = updatedCount;
        int updatedCountCorrect = mL.getCountCorrect();
        Log.d("logD", "checkResponse:countCorrect " + updatedCountCorrect);
        //set localCount to correctCount
        countCorrect = updatedCountCorrect;
        checkCountLoop(countLoop, countCorrect);
        //clears equation values
        playGameActivity.clearText();

        //replaced with previous code using interface

/*

        if (op.equalsIgnoreCase("+")) {
            Addition addition = new Addition(currentLevel, second, parsedResponse, countLoop, countCorrect);
            //get correct or wrong toast message from doMath();
            String toastText = addition.doMath();
            //display toast message
            playGameActivity.displayToast(toastText);
            sc.soundCheck(toastText);

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
        } else if (op.equalsIgnoreCase("-")) {
            Subtraction subtraction = new Subtraction(currentLevel, second, parsedResponse, countLoop, countCorrect);
            //get correct or wrong toast message from doMath();
            String toastText = subtraction.doMath();
            //display toast message
            playGameActivity.displayToast(toastText);
            sc.soundCheck(toastText);

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

        } else if (op.equalsIgnoreCase("*")) {
            Multiplication multiplication = new Multiplication(currentLevel, second, parsedResponse, countLoop, countCorrect);
            //get correct or wrong toast message from doMath();
            String toastText = multiplication.doMath();
            //display toast message
            playGameActivity.displayToast(toastText);
            sc.soundCheck(toastText);

            //get correctCount from Multiplication
            int updatedCount = multiplication.getCountLoop();
            Log.d("logD", "checkResponse:updatedCount " + updatedCount);
            countLoop = updatedCount;

            int updatedCountCorrect = multiplication.getCountCorrect();
            Log.d("logD", "checkResponse:countCorrect " + updatedCountCorrect);
            //set localCount to correctCount
            countCorrect = updatedCountCorrect;

            checkCountLoop(countLoop, countCorrect);
            //clears equation values
            playGameActivity.clearText();

        } else if (op.equalsIgnoreCase("/")) {
            Division division = new Division(currentLevel, second, parsedResponse, countLoop, countCorrect, first);
            //get correct or wrong toast message from doMath();
            String toastText = division.doMath();
            //display toast message
            playGameActivity.displayToast(toastText);
            sc.soundCheck(toastText);

            //get correctCount from Multiplication
            int updatedCount = division.getCountLoop();
            Log.d("logD", "checkResponse:updatedCount " + updatedCount);
            countLoop = updatedCount;

            int updatedCountCorrect = division.getCountCorrect();
            Log.d("logD", "checkResponse:countCorrect " + updatedCountCorrect);
            //set localCount to correctCount
            countCorrect = updatedCountCorrect;

            checkCountLoop(countLoop, countCorrect);
            //clears equation values
            playGameActivity.clearText();

        }*/
    }

    /**
     * public method checkCountLoop
     *
     * @param cntLoop    int
     * @param cntCorrect int
     * @return void
     * purpose: check countLoop total and if 7 of 10 correct, pass to next level  and display toast
     */
    public void checkCountLoop(int cntLoop, int cntCorrect) {
        if (cntLoop > 10) {

            if (cntCorrect >= 7) {
                currentLevel++;
                starCount++;
                countCorrect = 0;
                countLoop = 0;
                playGameActivity.displayToast("You passed this level!");
                sp.playYaySound();
            } else {
                playGameActivity.displayToast("Let's practice more.");
                countCorrect = 0;
                countLoop = 0;
            }
        }
    }

    /**
     * public method checkLevelLoop
     * check if addition level completed and move to next stage of subtraction
     * check if subtraction level completed and move to multiplication
     * check if multiplication level completed and move to division
     * @return void
     */
    public void checkLevelLoop() {
        if (currentLevel > 10 && currentLevel < 21) {
            if (op.equalsIgnoreCase("+")) {
                currentStage = 1;
                op = "-";
                currentLevel = 10;
            } else if (currentStage == 2) {
                currentStage = 3;
                op = "/";
                currentLevel = 1;
            }
            else if (currentStage ==3 ){
                playGameActivity.displayCongrats();
                currentLevel=1;
                currentStage=0;
                op = "+";
            }


        } else if (currentLevel >= 21) {
            op = "*";
            currentStage = 2;
            currentLevel = 1;
        }

    }

}
