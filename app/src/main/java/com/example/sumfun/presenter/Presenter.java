package com.example.sumfun.presenter;

import com.example.sumfun.model.User;
import com.example.sumfun.view.MainActivity;

public class Presenter {
    private MainActivity mainActivity;
    private User user;

    public Presenter(MainActivity mainActivity){
        this.mainActivity=mainActivity;
        user = new User(this);
        user.loadUser();
    }
    public void saveData(){
        user.saveUser();
    }

}

