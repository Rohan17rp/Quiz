package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HighScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

    }
    public void mathsPressed(View m) {
        startActivity(new Intent(this, MathsScores.class));
        finish();
    }
    public void animePressed(View a) {
        startActivity(new Intent(this, AnimeScores.class));
        finish();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
