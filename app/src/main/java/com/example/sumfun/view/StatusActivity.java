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

/**
 * public class StatusActivity extends AppCompatActivity
 * statusPresenter StatusPresenter, message and starCountDisplay TextViews, starView ImageView
 * purpose: display user current star count
 */
public class StatusActivity extends AppCompatActivity {
    StatusPresenter statusPresenter;
   // private int starCount;
    TextView message;
    ImageView starView;
    TextView starCountDisplay;

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

    /**
     * public method displayToast
     * @param message string
     * purpose: display Toast with message
     */
    public void displayToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_LONG);
       // toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();
    }

    /**
     * public method showStatusDisplay
     * @param starCnt int
     * passes value of starCnt as String message of Toast
     */
    public void showStatusDisplay(int starCnt){
        starCountDisplay.setText(String.valueOf(starCnt));

    }

}