package com.example.sumfun.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.sumfun.R;
import com.example.sumfun.presenter.Presenter;

public class StatusActivity extends AppCompatActivity {
    private Presenter presenter;
    private int starCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);


    }
}