package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.MainActivity;


public class MainPresenter {
    private MainActivity mainActivity;
    private User user;

    public MainPresenter(MainActivity mainActivity){
        this.mainActivity= mainActivity;

            user = new User();
            user=user.loadUser(this.mainActivity);
    }
    public void saveData(User u){
        user.saveUser(mainActivity, u);
    }

    //activate menu
    public void activateMenu(){
        //display correct things on screen
        Log.d("logD", "activateMenu: ");
        mainActivity.displayToast("hello player, level: "+user.getCurrentLevel());
    }




}

