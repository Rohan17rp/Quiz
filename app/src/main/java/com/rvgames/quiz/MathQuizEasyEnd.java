package com.rvgames.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MathQuizEasyEnd extends AppCompatActivity {
    int score, highscore;
    String Score, highScore;
    Animation blink;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz_easy_end);

        pref = this.getSharedPreferences("myPrefKeys", Context.MODE_PRIVATE);
        editor= pref.edit();
        TextView scoreView = findViewById(R.id.fScore);
        TextView HighScoreView = findViewById(R.id.highscoreME);
        TextView exit =findViewById(R.id.blinkView);
        Intent end = getIntent();
        score = end.getIntExtra("scoreVal", 0);
        Score = Integer.toString(score);
        scoreView.setText(Score);

        highscore = pref.getInt("MEhighscore", 0);
        if(score > highscore) {
            highscore = score;
            editor.putInt("MEhighscore",highscore);
            editor.commit();
        }
        highscore = pref.getInt("MEhighscore", 0);
        highScore = Integer.toString(highscore);
        HighScoreView.setText(highScore);

        blink = new AlphaAnimation(0.0f ,1.0f);
        blink.setDuration(50);
        blink.setStartOffset(20);
        blink.setRepeatMode(Animation.REVERSE);
        blink.setRepeatCount(Animation.INFINITE);
        exit.startAnimation(blink);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        MathQuizEasyEnd.this.finish();
    }
}
