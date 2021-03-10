package com.example.sumfun.presenter;
/**
 * public class Division
 * purpose: process equation and check for correct response
 */
public class Division {
    int currentLevel;
    int second;
    String toastText;
    int response;
    int countLoop;
    int countCorrect;
    int first;


    /**
     * constructor for Multiplication
     * @param cLevel int
     * @param rand int
     * @param response int
     * @param countLoop int
     * @param countCorrect int
     */
    public Division(int cLevel, int rand, int response, int countLoop, int countCorrect, int first) {
        this.currentLevel = cLevel;
        this.second = rand;
        this.response = response;
        this.countLoop= countLoop;
        this.countCorrect=countCorrect;
        this.first= first;

    }

    /**
     * public method doMath
     * @return string
     * purpose: check whether response is correct or not and send toast with message
     */
    //will need new logic to function properly
    public String doMath(){

        if (response == (first / currentLevel)) {
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
