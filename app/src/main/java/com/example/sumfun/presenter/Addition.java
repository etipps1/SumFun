package com.example.sumfun.presenter;

/**
 * public class Addition
 * purpose: process equation and check for correct response
 * int currentLevel, second, response, countLoop, countCorrect
 * String toastText
 * implements MathLevel
 */
public class Addition implements MathLevel{
    int currentLevel;
    int second;
    String toastText;
    int response;
    int countLoop;
    int countCorrect;


    /**
     * constructor for Addition
     * @param cLevel int
     * @param rand int
     * @param response int
     * @param countLoop int
     * @param countCorrect int
     */
    public Addition(int cLevel, int rand, int response, int countLoop, int countCorrect) {
        this.currentLevel = cLevel;
        this.second = rand;
        this.response = response;
        this.countLoop= countLoop;
        this.countCorrect=countCorrect;

    }

    /**
     * public method addLevel
     * @return string
     * purpose: check whether response is correct or not and send toast with message
     */
    public String doMath(){

        if (response == currentLevel + second) {
            countCorrect++;
            countLoop++;
            toastText = "Correct";

        } else {
            countLoop++;
            toastText = "Wrong";

        }
        return toastText;


    }

    /**
     * getter for countLoop
     * @return countLoop
     */
    public int getCountLoop() {
        return countLoop;
    }

    /**
     * getter for countCorrect
     * @return  countCorrect
     */
    public int getCountCorrect() {
        return countCorrect;
    }
}
