package com.example.sumfun.presenter;

import com.example.sumfun.model.User;
import com.example.sumfun.view.MainActivity;
import com.example.sumfun.view.PlayGameActivity;
import com.example.sumfun.view.StatusActivity;

public class Presenter {
    private MainActivity mainActivity;
    private PlayGameActivity playGameActivity;
    private StatusActivity statusActivity;
    private User user;
    Boolean first=true;

    public Presenter(MainActivity mainActivity){
        this.mainActivity= mainActivity;
        if (first){
            user= new User();
        }
        else {
            user = new User(this);
            user.loadUser();
        }
    }
    public void saveData(User user){
        user.saveUser(user);
    }



}

