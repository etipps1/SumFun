package com.example.sumfun.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.example.sumfun.R;
import com.example.sumfun.presenter.MainPresenter;
import com.example.sumfun.presenter.StatusPresenter;

public class StatusActivity extends AppCompatActivity {
    private StatusPresenter statusPresenter;
    private int starCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        statusPresenter= new StatusPresenter(this);


    }
    public void displayToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();
    }

}