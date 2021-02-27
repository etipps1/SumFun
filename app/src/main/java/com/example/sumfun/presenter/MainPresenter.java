package com.example.sumfun.presenter;

import android.util.Log;

import com.example.sumfun.model.User;
import com.example.sumfun.view.MainActivity;


public class MainPresenter {
    private MainActivity mainActivity;
    private User user;
    Boolean first=false;//change to regulate in user.loadUser

    public MainPresenter(MainActivity mainActivity){
        this.mainActivity= mainActivity;
        //change to regulate in user.loadUser
       /* if (first){
            user= new User();
        }
        else {*/
            user = new User();
            user.loadUser();
       // }
    }
    public void saveData(User user){
        user.saveUser(user);
    }

    //activate menu
    public void activateMenu(){
        //display correct things on screen
        Log.d("logD", "activateMenu: ");
        mainActivity.displayToast("hello player, level: "+user.getCurrentLevel());
    }



}

