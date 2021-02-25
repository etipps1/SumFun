package com.example.sumfun.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sumfun.R;
import com.example.sumfun.presenter.Presenter;

public class MainActivity extends AppCompatActivity {
    private Presenter presenter;
    private Button bPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bPlay=findViewById(R.id.bPlay);

        presenter= new Presenter(this);

        bPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePlayButton();

            }
        });

    }
    public void handlePlayButton(){
        Intent intent = new Intent(this, PlayGameActivity.class);
        startActivity(intent);
    }

}