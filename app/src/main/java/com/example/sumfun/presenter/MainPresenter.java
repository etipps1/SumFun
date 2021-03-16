package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.MainActivity;

/**
 * public class MainPresenter
 * purpose: background process for MainActivity, begins game
 * private MainActivity mainActivity
 * private User user
 */


public class MainPresenter {
    private MainActivity mainActivity;
    private User user;

    /**
     * public constructor for MainPresenter
     * @param mainActivity MainActivity
     */

    public MainPresenter(MainActivity mainActivity){
        this.mainActivity= mainActivity;

            user = new User();
            user=user.loadUser(this.mainActivity);
    }

    /**
     * public method saveData
     * @param u User
     * @return void
     * purpose: call user.saveUser() and pass mainActivity and current u state
     */
    public void saveData(User u){
        user.saveUser(mainActivity, u);
    }

    //activate menu
    /**
     * public method activateMenu
     * @return void
     * purpose: display Hello toast on mainActivity
     */
    public void activateMenu(){
        //display correct things on screen
        Log.d("logD", "activateMenu: ");
        //mainActivity.displayToast("hello player, level: "+user.getCurrentLevel());
        mainActivity.displayToast("Hello!");
    }




}

