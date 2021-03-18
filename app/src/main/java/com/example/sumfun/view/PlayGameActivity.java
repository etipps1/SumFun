package com.example.sumfun.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sumfun.R;
import com.example.sumfun.presenter.PlayGamePresenter;
import com.example.sumfun.presenter.SoundCheck;
import com.example.sumfun.presenter.SoundPlayer;

/**
 * public class PlayGameActivity extends AppCompatActivity
 * purpose: view for PlayGamePresenter
 * TextView first_num, operator, second_num, equals
 * EditText response
 * Button check, next
 * SoundCheck sc, SoundPlayer sp
 */
public class PlayGameActivity extends AppCompatActivity {
    //for playGameActivity
    PlayGamePresenter playGamePresenter;

    TextView first_num;
    TextView operator;
    TextView second_num;
    TextView equals;
    EditText response;
    Button check;
    Button next;
    SoundCheck sc;
    SoundPlayer sp;

    /**
     * @Override protected onCreate
     * @param savedInstanceState Bundle
     * @return void
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        first_num = findViewById(R.id.firstNum);
        second_num = findViewById(R.id.secondNum);
        operator = findViewById(R.id.operator);
        equals = findViewById(R.id.equals);
        response = findViewById(R.id.response);
        check = findViewById(R.id.check);
        next = findViewById(R.id.next);
        sc = new SoundCheck(this);  //this class is an activity so my variable is a context which is why I use this.
        sp = new SoundPlayer(this);

        playGamePresenter = new PlayGamePresenter(this);

        /*listener for check button*/
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleCheckBtn();
            }
        });


        /*listener for next button*/
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleNextBtn();
            }
        });

        playGamePresenter.activateGame();

    }

    /**
     * public method displayToast
     * @param message string
     * purpose: to display message toast in center of screen
     * @return void
     */
    public void displayToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 300);
        toast.show();
    }

    /**
     * public method showEquation
     * @param first  int
     * @param op     string
     * @param second int
     * purpose: send correct values to display equation
     * @return void
     */
    public void showEquation(int first, String op, int second) {
        first_num.setText(String.valueOf(first));
        operator.setText(op);
        second_num.setText(String.valueOf(second));

    }

    /**
     * public method handleCheckBtn
     * purpose: pass values to checkResponse for validation
     * @return void
     */
    public void handleCheckBtn() {
        try {
            String firNum = first_num.getText().toString();

            String resp = response.getText().toString();
            String secNum = second_num.getText().toString();
            int second = Integer.parseInt(secNum);
            int first = Integer.parseInt(firNum);
            playGamePresenter.checkResponse(second, resp, first);
            //clearText();
        } catch (Exception ex) {
            ex.getStackTrace();
            displayToast("press next");
        }

    }

    /**
     * pubic method clearText
     * purpose: clear equation values
     * @return void
     */
    public void clearText() {
        first_num.setText("");
        //operator.setText("");
        second_num.setText("");
        response.setText("");

    }

    /**
     * public method handleNextBtn
     * purpose: clear values on button click and populate with new equation
     * @return void
     */
    public void handleNextBtn() {
        clearText();
        playGamePresenter.submitEquation();

    }

    /**
     * public method displayCongrats
     * @return void
     * purpose: send intent to CongratsActivity when all levels are completed
     */

    public void displayCongrats(){
        Log.d("logD", "displayCongrats: ");
        Intent intent= new Intent(this, CongratsActivity.class);
        startActivity(intent);

    }

    /**
     * @Override protected onStop
     * @return void
     * purpose: saveData on Stop
     */

    @Override
    protected void onStop() {
        super.onStop();
        playGamePresenter.saveData(this);
    }

}