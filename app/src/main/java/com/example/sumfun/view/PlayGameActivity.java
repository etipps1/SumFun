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
import com.example.sumfun.presenter.MainPresenter;
import com.example.sumfun.presenter.PlayGamePresenter;

public class PlayGameActivity extends AppCompatActivity {
    private PlayGamePresenter playGamePresenter;
    //for playGameActivity

    private TextView first_num;
    private TextView operator;
    private TextView second_num;
    private TextView equals;
    private EditText response;
    //private int curLevel;
    Button check;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        first_num=findViewById(R.id.firstNum);
        second_num=findViewById(R.id.secondNum);
        operator=findViewById(R.id.operator);
        equals=findViewById(R.id.equals);
        response=findViewById(R.id.response);
        check=findViewById(R.id.check);
        next=findViewById(R.id.next);

       // second_num.setText(rand);
       // first_num.setText(curLevel);
        //operator.setText();
       playGamePresenter = new PlayGamePresenter(this);
       check.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               handleCheckBtn();
           }
       });

       next.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               handleNextBtn();
           }
       });

       playGamePresenter.activateGame();


    }
    public void displayToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();
    }
    public void showEquation(int first, String op, int second){
        first_num.setText(String.valueOf(first));
        operator.setText(op);
        second_num.setText(String.valueOf(second));

    }
    public void handleCheckBtn() {
        String resp = response.getText().toString();
        String secNum= second_num.getText().toString();
        int second=Integer.parseInt(secNum);
        playGamePresenter.checkResponse(second, resp);

    }
    public void clearText(){
        first_num.setText("");
        operator.setText("");
        second_num.setText("");
        response.setText("");

    }
    public void handleNextBtn(){
        clearText();
        playGamePresenter.submitEquation();

    }

}