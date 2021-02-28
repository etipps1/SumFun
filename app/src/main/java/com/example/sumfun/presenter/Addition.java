package com.example.sumfun.presenter;

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

    public Addition(){

    }
    public Addition(int cLevel, int rand, int response, int countLoop, int countCorrect) {
        this.currentLevel = cLevel;
        this.second = rand;
        this.response = response;
        this.countLoop= countLoop;
        this.countCorrect=countCorrect;

    }
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

    public int getCountLoop() {
        return countLoop;
    }
    public int getCountCorrect() {
        return countCorrect;
    }
}
