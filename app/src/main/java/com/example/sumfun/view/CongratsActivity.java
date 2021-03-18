package com.example.sumfun.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sumfun.R;

/**
 * public class CongratsActivity extends AppCompatActivity
 * purpose: display congratulations when all levels are completed
 * TextViews commentTextView, congratsTextView
 * ImageView logoTextView
 */

public class CongratsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        //add animations
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.up);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.down);

        TextView commentTextView = findViewById(R.id.commentTextView);
        TextView congratsTextView = findViewById(R.id.congratsTextView);
        ImageView logoTextView = findViewById(R.id.logoTextView);

        commentTextView.setAnimation(animation2);
        congratsTextView.setAnimation(animation2);
        logoTextView.setAnimation(animation1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(CongratsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 8000);
    }
}