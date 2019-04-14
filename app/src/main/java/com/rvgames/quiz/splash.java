package com.rvgames.quiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splash extends AppCompatActivity {

    static final Handler timer = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
        timer.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextAvctivity();
            }
        }, 3000);
    }
    public void nextAvctivity() {
        startActivity(new Intent(this, MainActivity.class));
        timer.removeCallbacksAndMessages(null);
        finish();
    }
}
