package com.example.sumfun.presenter;

import android.content.Context;

/**
 * public class SoundCheck
 * purpose: check if answer is correct to play correct sound or if not correct to play wrong sound.
 */

public class SoundCheck {
    SoundPlayer sound;

    /**
     * public constructor for SoundCheck
     * @param c Context
     */
    public SoundCheck(Context c) {  //needs to have a context
        sound = new SoundPlayer(c );
    }

    /**
     * public method SoundCheck
     * @param toastText String
     * purpose: pulls toast that states if answer is correct or wrong and if toast is correct
     * plays the correct answer sound, else plays the wrong answer sound.
     */
    public void soundCheck(String toastText){
        if (toastText.equals("Correct")) { //don't compare strings with == use equal() java doesn't like it.
            sound.playCorrectSound();
        }  else {
            sound.playWrongSound();
        }
    }
//    public void setSound(SoundPlayer sound) {
//        this.sound = sound;
//    }
}
