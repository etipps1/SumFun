package com.example.sumfun.presenter;

/**
 * Subtraction level class
 * currentLevel, second, response, countLoop, countCorrect int
 * toastText String
 * purpose: process equation and check for correct response
 * implements MathLevel
 */
public class Subtraction implements MathLevel{
    int currentLevel;
    int second;
    String toastText;
    int response;
    int countLoop;
    int countCorrect;

    /**
     * constructor for Subtraction
     * @param cLevel int
     * @param rand int
     * @param response int
     * @param countLoop int
     * @param countCorrect int
     */

    public Subtraction(int cLevel, int rand, int response, int countLoop, int countCorrect) {
        this.currentLevel = cLevel;
        this.second = rand;
        this.response = response;
        this.countLoop= countLoop;
        this.countCorrect=countCorrect;

    }

    /**
     * public subLevel
     * @return string
     * purpose: check equation for correct response and return toast message
     */
    public String doMath() {
        if (response == currentLevel - second) {
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
     * countLoop getter
     * @return countLoop int
     */
    public int getCountLoop() {
        return countLoop;
    }

    /**
     * countCorrect getter
     * @return countCorrect int
     */
    public int getCountCorrect() {
        return countCorrect;
    }

}
