package com.example.sumfun.presenter;
/**
 * public class Multiplication
 * purpose: process equation and check for correct response
 * currentLevel, second, response, countLoop, countCorrect int
 * toastText String
 * implements MathLevel
 */
public class Multiplication implements MathLevel{
    int currentLevel;
    int second;
    String toastText;
    int response;
    int countLoop;
    int countCorrect;


    /**
     * constructor for Multiplication
     * @param cLevel int
     * @param rand int
     * @param response int
     * @param countLoop int
     * @param countCorrect int
     */
    public Multiplication(int cLevel, int rand, int response, int countLoop, int countCorrect) {
        this.currentLevel = cLevel;
        this.second = rand;
        this.response = response;
        this.countLoop= countLoop;
        this.countCorrect=countCorrect;

    }

    /**
     * public method doMath
     * @return string
     * purpose: check whether response is correct or not and send toast with message
     */
    public String doMath(){

        if (response == currentLevel * second) {
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
