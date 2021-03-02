package com.example.sumfun.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sumfun.R;
import com.example.sumfun.presenter.PlayGamePresenter;

/**
 * public class PlayGameActivity extends AppCompatActivity
 * purpose: view for PlayGamePresenter
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
 */
    public void displayToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    /**
     * public method showEquation
     * @param first int
     * @param op string
     * @param second int
     * purpose: send correct values to display equation
     */
    public void showEquation(int first, String op, int second) {
        first_num.setText(String.valueOf(first));
        operator.setText(op);
        second_num.setText(String.valueOf(second));

    }

    /**
     * public method handleCheckBtn
     * purpose: pass values to checkResponse for validation
     */
    public void handleCheckBtn() {
        try{
        String resp = response.getText().toString();
        String secNum = second_num.getText().toString();
        int second = Integer.parseInt(secNum);
        playGamePresenter.checkResponse(second, resp);
        //clearText();
            }
        catch (Exception ex){
            ex.getStackTrace();
            displayToast("press next");
        }




    }

    /**
     * pubic method clearText
     * purpose: clear equation values
     */
    public void clearText() {
        first_num.setText("");
        operator.setText("");
        second_num.setText("");
        response.setText("");

    }

    /**
     * public method handleNextBtn
     * purpose: clear values on button click and populate with new equation
     */
    public void handleNextBtn() {
        clearText();
        playGamePresenter.submitEquation();

    }

    @Override
    protected void onStop() {
        super.onStop();
        playGamePresenter.saveData();
    }

}