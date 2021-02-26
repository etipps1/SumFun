package com.example.sumfun.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sumfun.R;
import com.example.sumfun.presenter.Presenter;

public class MainActivity extends AppCompatActivity {
    private Presenter presenter;

    private Button bPlay;
    private TextView welcome;
    private ImageView star;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bPlay = findViewById(R.id.bPlay);
        welcome = findViewById(R.id.welcome);
        star=findViewById(R.id.star);

        presenter = new Presenter(this);

        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePlayButton();

            }
        });
        presenter.activateMenu();

    }
    public void handlePlayButton(){
        Intent intent = new Intent(this, PlayGameActivity.class);
        startActivity(intent);

    }
    public void displayToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();
    }

    }
