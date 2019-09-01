package com.rvgames.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HighScore extends AppCompatActivity {

    SharedPreferences sharedPreferences_endlessHighscore;

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
    public void endlessPressed(View endless){
        sharedPreferences_endlessHighscore = getSharedPreferences("HighScoreVal", MODE_PRIVATE);
        int endless_highscore = sharedPreferences_endlessHighscore.getInt("HighScoreVal",0);
        Toast.makeText(this, Integer.toString(endless_highscore),Toast.LENGTH_LONG).show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
