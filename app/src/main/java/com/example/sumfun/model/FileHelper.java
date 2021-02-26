package com.example.sumfun.model;

import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {
    User user;

    public FileHelper(User user){
        this.user=user;
    }

    public User getUser() {
        return user;
    }


    public void saveUser(){
        String filename="SumFunSavedUser.txt";
        Gson gson = new Gson();
        String userData = gson.toJson(user);
        try(Writer w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(filename), "UTF-8"))) {
            w.write(userData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User loadUser(){
        String userData= null;
        String filename="SumFunSavedUser.txt";
        User savedUser= new User();
        try{
            byte[] encoded = Files.readAllBytes(Paths.get(filename));
            userData = new String(encoded, "UTF-8");
        } catch (IOException e) {
            //getUser();
            e.printStackTrace();
            return savedUser;

        }

        Gson gson = new Gson();
        savedUser = gson.fromJson(userData, User.class);
        Log.d("logD", "loadUser: "+savedUser);

        return savedUser;


    }
}
