package com.example.sumfun.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sumfun.R;
import com.example.sumfun.presenter.MainPresenter;

/**
 * public class MainActivity extends AppCompatActivity
 * MainPresenter mainPresenter
 * Button bPlay, TextView welcome, ImageView star
 * purpose: display and handle activity from main screen
 */

public class MainActivity extends AppCompatActivity {
    MainPresenter mainPresenter;

    Button bPlay;
    TextView welcome;
    ImageView star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bPlay = findViewById(R.id.bPlay);
        welcome = findViewById(R.id.welcome);
        star=findViewById(R.id.star);

        mainPresenter = new MainPresenter(this);

        //check for click of bPlay
        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePlayButton();

            }
        });

        //check for click of star
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleStarClicked();
            }
        });
        mainPresenter.activateMenu();

    }

    /**
     * public method handlePlayButton
     * purpose: pass intent to PlayGameActivity to begin on click
     */
    public void handlePlayButton(){
        Log.d("logD", "handlePlayButton: inside");
        Intent intent = new Intent(this, PlayGameActivity.class);
        startActivity(intent);

    }

    /**
     * public method handleStarClicked
     * purpose: pass intent to StatusActivity to begin on click
     */
    public void handleStarClicked()
    {
        Log.d("logD", "handleStarClicked: inside");
        Intent intent = new Intent(this, StatusActivity.class);
        startActivity(intent);

    }

    /**
     * public method displayToast
     * @param message String
     * purpose: display toast with passed message
     */
    public void displayToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_SHORT);
       // toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();
    }

    }
