package com.rvgames.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class AnimeEasyEnd extends AppCompatActivity {

    int score, highScore;
    TextView scoreView, highScoreView, blinkView;
    String Score, HighScore;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Animation blink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_easy_end);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        blinkView = findViewById(R.id.blinkView100);
        scoreView = findViewById(R.id.fAEScore);
        highScoreView = findViewById(R.id.highscoreAE);
        Intent end = getIntent();
        score = end.getIntExtra("score", 0);
        Score = Integer.toString(score);
        scoreView.setText(Score);

        pref = this.getSharedPreferences("player_score_preference", Context.MODE_PRIVATE);
        editor = pref.edit();
        highScore = pref.getInt("AEhighscore", 0);
        if(score > highScore) {
            highScore = score;
            editor.putInt("AEhighscore", highScore);
            editor.commit();
        }
        HighScore = Integer.toString(highScore);
        highScoreView.setText(HighScore);

        blink = new AlphaAnimation(0.0f, 1.0f);
        blink.setDuration(100);
        blink.setStartOffset(50);
        blink.setRepeatMode(Animation.REVERSE);
        blink.setRepeatCount(Animation.INFINITE);
        blinkView.startAnimation(blink);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
