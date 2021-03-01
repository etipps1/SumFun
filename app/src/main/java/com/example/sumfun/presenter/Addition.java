package com.example.sumfun.presenter;

/**
 * public class Addition
 * purpose: process equation and check for correct response
 */
public class Addition {
    //Boolean correct= false;
    //Boolean passed_level= false;
    //Boolean valid_response= false;
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
    public String addLevel(){
        //int count = 0;

        if (response == currentLevel + second) {
            //correct = true;
            countCorrect++;
            countLoop++;
            toastText = "Correct";
            // System.out.println("Correct");
            //valid_response = false;

        } else {
            countLoop++;
            toastText = "Wrong";
            //System.out.println("Wrong");
            //valid_response = false;

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
