package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.StatusActivity;

/**
 * public class StatusPresenter
 * private Status Activity statusActivity
 * private User user
 * purpose: display dashboard for accomplishments
 */
public class StatusPresenter {
    private StatusActivity statusActivity;
    private User user;

    /**
     * public constructor for StatusPresenter
     * @param statusActivity StatusActivity
     */
    public StatusPresenter(StatusActivity statusActivity){
        this.statusActivity=statusActivity;
        user = new User();
        user=user.loadUser(this.statusActivity);

    }

    /**
     * public method submitStatusDisplay
     * purpose: send getStarCount to showStatusDisplay
     */
    public void submitStatusDisplay(){
        statusActivity.showStatusDisplay(user.getStarCount());

    }

    /**
     * public method submitBadgeDisplay
     * purpose: send getCurrentStage to showBadgeDisplay
     */
    public void submitBadgeDisplay(){
        statusActivity.showBadgeDisplay(user.getCurrentStage());
    }

    /**
     * public activateStarCount
     * send getStarCount to statusActivity to display toast message
     */
    //activate game
    public void activateStarCount(){
        //display correct things on screen
        Log.d("logD", "activateStarCount: ");
        statusActivity.displayToast("Your stars: "+user.getStarCount());
    }
}

