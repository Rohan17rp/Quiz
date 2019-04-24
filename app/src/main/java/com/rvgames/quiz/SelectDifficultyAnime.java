package com.rvgames.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SelectDifficultyAnime extends AppCompatActivity {
    int EasyScore,MediumScore;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty_anime);

        pref = this.getSharedPreferences("player_score_preference", Context.MODE_PRIVATE);
        EasyScore = pref.getInt("AEhighscore", 0);
        MediumScore = pref.getInt("AMhighscore", 0);
    }
    public void selectEasy (View que1) {
        startActivity(new Intent(this, AnimeEasy.class));
        SelectDifficultyAnime.this.finish();
    }
    public void startMediumQuiz(View M) {
        if(EasyScore < 60) {
            Toast
                    .makeText(SelectDifficultyAnime.this, "Score in difficulty Easy should be more than 40 to unlock Medium", Toast.LENGTH_LONG)
                    .show();
        } else {
            startActivity(new Intent(this, AnimeEasy.class));
            finish();
        }
    }
    public void startHardQuiz(View H) {
        if(MediumScore < 60) {
            Toast
                    .makeText(SelectDifficultyAnime.this, "Score in difficulty Medium should be more than 40 to unlock Hard", Toast.LENGTH_LONG)
                    .show();
        } else {
            Toast
                    .makeText(SelectDifficultyAnime.this, "Coming Soon..", Toast.LENGTH_LONG)
                    .show();
        }
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, quizSection.class));
        SelectDifficultyAnime.this.finish();
    }
}
