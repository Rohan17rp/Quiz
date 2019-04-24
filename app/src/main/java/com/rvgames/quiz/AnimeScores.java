package com.rvgames.quiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnimeScores extends AppCompatActivity {

    int E,M,H;
    String easy, medium, hard;
    SharedPreferences pref;
    TextView Easy, Medium, Hard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_scores);

        Easy = findViewById(R.id.AEFHS);
        Medium = findViewById(R.id.AMFHS);
        Hard = findViewById(R.id.AHFHS);

        pref = this.getSharedPreferences("player_score_preference", MODE_PRIVATE);
        E = pref.getInt("AEhighscore", 0);
        M = pref.getInt("AMhighscore", 0);
        H = pref.getInt("AHhighscore", 0);

        easy = Integer.toString(E);
        medium = Integer.toString(M);
        hard = Integer.toString(H);

        Easy.setText(easy);
        Medium.setText(medium);
        Hard.setText(hard);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HighScore.class));
        finish();
    }
}
