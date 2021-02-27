package com.example.sumfun.presenter;

public class Addition {
    Boolean correct= false;
    Boolean passed_level= false;
    Boolean valid_response= false;
    int currentLevel;
    int rand;
    String toastText;
    int response;

    public Addition(){

    }
    public Addition(int cLevel, int rand, int response) {
        this.currentLevel = cLevel;
        this.rand = rand;
        this.response = response;

    }
    public String addLevel(){
        //int count = 0;

        if (response == currentLevel + rand) {
            correct = true;
           // count++;
            toastText = "Correct";
            // System.out.println("Correct");
            valid_response = false;

        } else {
            toastText = "Wrong";
            //System.out.println("Wrong");
            valid_response = false;

        }
        return toastText;


    }
}
