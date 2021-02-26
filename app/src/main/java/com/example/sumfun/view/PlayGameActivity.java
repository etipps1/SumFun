package com.example.sumfun.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sumfun.R;
import com.example.sumfun.presenter.Presenter;

public class PlayGameActivity extends AppCompatActivity {
    private Presenter presenter;
    //for playGameActivity

    private TextView first_num;
    private TextView operator;
    private TextView second_num;
    private TextView equals;
    private EditText response;
    private int rand;
    private int curLevel;
    Button check;

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

       // second_num.setText(rand);
       // first_num.setText(curLevel);
        //operator.setText();
       // presenter = new Presenter(this);


    }
    public void displayToast(String message){
        Toast toast=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();
    }
}