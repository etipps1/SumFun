package com.example.sumfun.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sumfun.R;

public class LogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Splash screen full screen without top bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logo);

        //add animations
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.up);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.down);

        TextView byTextView = findViewById(R.id.byTextView);
        TextView teamTextView = findViewById(R.id.teamTextView);
        ImageView logoImageView = findViewById(R.id.logoImageView);

        byTextView.setAnimation(animation2);
        teamTextView.setAnimation(animation2);
        logoImageView.setAnimation(animation1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LogoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}