package com.example.sumfun.model;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * public class FileHelper
 * purpose: save User object and load User object with Gson/JSON
 */
public class FileHelper {
    Context context;
    User user;

    public FileHelper(User user){
    this.user=user;
    }
    public FileHelper(Context context, User user) {
        this.context = context;
        this.user = user;
    }
    public FileHelper(Context context){
        this.context=context;
    }


    public void saveUser(){
        String filename="SumFunSavedUser.txt";
        Gson gson = new Gson();
        Log.d("logD", "saveUser: inside FH");
        String userData = gson.toJson(user);
        Log.d("logD", "saveUser:userData= "+ userData);
        try(Writer w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(filename), "UTF-8"))) {
            w.write(userData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    String filename = "myfile";
    String fileContents = "Hello world!";
try (FileOutputStream fos = context.openFileOutput(filename, Context.MODE_PRIVATE)) {
        fos.write(fileContents.toByteArray());
    }*/

    public static User loadUser() {//context
        String userData = null;
        String filename = "SumFunSavedUser.txt";
        User savedUser = new User();
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(filename));
            userData = new String(encoded, "UTF-8");
        } catch (IOException e) {
            //getUser();
            e.printStackTrace();
            return savedUser;
        }

        Gson gson = new Gson();
        savedUser = gson.fromJson(userData, User.class);
        Log.d("logD", "loadUser: " + savedUser);

        return savedUser;
    }

/*

    FileInputStream fis = context.openFileInput(filename);
    InputStreamReader inputStreamReader =
            new InputStreamReader(fis, StandardCharsets.UTF_8);
    StringBuilder stringBuilder = new StringBuilder();
try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
        String line = reader.readLine();
        while (line != null) {
        stringBuilder.append(line).append('\n');
        line = reader.readLine();
        }
        } catch (IOException e) {
        // Error occurred when opening raw file for reading.
        } finally {
        String contents = stringBuilder.toString();
        }*/


    //local public void saveFile(View view) {
    public void saveUser2() {


        try {
            String filename = "SumFunSavedUser.txt";
            Gson gson = new Gson();
            Log.d("logD", "saveUser2: inside FH");
            String userData = gson.toJson(user);
            Log.d("logD", "saveUser2:userData= " + userData);


            // openFileOutput is the Android function to get a file for writing from the phone.  Wrapped the stream
            // into a BufferedWriter for ease of use.
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(context.openFileOutput("SumFunSavedUser.txt", Context.MODE_PRIVATE)));
            writer.write(userData);
            writer.close();
            Log.d("logD", "saveUser2: Wrote data to SumFunSavedUser.txt");
        } catch (IOException ioe) {

            Log.d("logD", ioe.toString());
        }
    }

    public User loadUser2 () {
        String userData = null;
        String filename = "SumFunSavedUser.txt";
        User savedUser = new User();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.openFileInput(filename)));
            String data = reader.readLine();
            reader.close();
            Log.d("FileHelper", "Finished reading from file: "+filename);
            Gson gson = new Gson();
            savedUser = gson.fromJson(userData, User.class);
            Log.d("logD", "loadUser: " + savedUser);
            return savedUser;
        }
        catch (IOException ioe) {
            Log.e("FileHelper","Error reading from file ("+filename+"): "+ioe);
            return savedUser;
        }

        //return savedUser;
    }
}