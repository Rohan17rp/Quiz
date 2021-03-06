package com.rvgames.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class selectDifficulty extends AppCompatActivity {
    int EasyScore,MediumScore;
    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        pref = this.getSharedPreferences("player_score_preference", Context.MODE_PRIVATE);
        EasyScore = pref.getInt("MEhighscore", 0);
        MediumScore = pref.getInt("MMhighscore", 0);
    }
    public void startEasyQuiz(View easy) {
        Intent que1 = new Intent(this, Question1.class);
        startActivity(que1);
        selectDifficulty.this.finish();
    }
    public void startMediumQuiz(View M) {
        if(EasyScore < 60) {
            Toast.makeText(selectDifficulty.this, "Score in difficulty Easy should be more than 40 to unlock Medium", Toast.LENGTH_LONG).show();
        } else {
            startActivity(new Intent(this, MathMediumQuestion1.class));
            finish();
        }
    }
    public void startHardQuiz(View H) {
        if(MediumScore < 60) {
            Toast.makeText(selectDifficulty.this, "Score in difficulty Medium should be more than 40 to unlock Hard", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(selectDifficulty.this, "Coming Soon..", Toast.LENGTH_LONG).show();
        }
    }
     @Override
     public void onBackPressed() {
        startActivity(new Intent(this, quizSection.class));
        selectDifficulty.this.finish();
     }
}
