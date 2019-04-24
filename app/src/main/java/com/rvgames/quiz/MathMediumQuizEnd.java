package com.rvgames.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MathMediumQuizEnd extends AppCompatActivity {

    int score, highScore;
    String Score, HighScore;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Animation blink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_quiz_end);
        TextView scoreView = findViewById(R.id.fScoreM);
        TextView highScoreView = findViewById(R.id.highscoreMM);
        TextView exit = findViewById(R.id.blinkView1);
        Intent last = getIntent();
        score = last.getIntExtra("scoreVal", 0);
        Score = Integer.toString(score);
        scoreView.setText(Score);
        pref = this.getSharedPreferences("player_score_preference", Context.MODE_PRIVATE);
        editor = pref.edit();
        highScore = pref.getInt("MMhighscore", 0);
        if(score > highScore) {
            highScore = score;
            editor.putInt("MMhighscore", highScore);
            editor.commit();
        }
        Score = Integer.toString(score);
        HighScore = Integer.toString(highScore);
        highScoreView.setText(HighScore);
        scoreView.setText(Score);
        blink = new AlphaAnimation(0.0f, 1.0f);
        blink.setDuration(100);
        blink.setStartOffset(50);
        blink.setRepeatMode(Animation.REVERSE);
        blink.setRepeatCount(Animation.INFINITE);
        exit.startAnimation(blink);
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}