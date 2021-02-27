package com.example.sumfun.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sumfun.R;
import com.example.sumfun.presenter.StatusPresenter;

public class StatusActivity extends AppCompatActivity {
    private StatusPresenter statusPresenter;
   // private int starCount;
    private TextView message;
    private ImageView starView;
    private TextView starCountDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        message= findViewById(R.id.starCountDisplay);
        starView=findViewById(R.id.starView);
        starCountDisplay=findViewById(R.id.starCountDisplay);

        statusPresenter= new StatusPresenter(this);
        statusPresenter.submitStatusDisplay();
        statusPresenter.activateStarCount();



    }
    public void displayToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_LONG);
       // toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();
    }

    public void showStatusDisplay(int starCnt){
        starCountDisplay.setText(String.valueOf(starCnt));

    }

}