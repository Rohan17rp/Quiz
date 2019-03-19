package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion1 extends AppCompatActivity {
    Runnable time;
    Handler timer;
    int score;
    String Score;
    Intent next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question1);

        next = new Intent(this, MathMediumQuestion2.class);
        timer = new Handler();
        TextView scoreView = findViewById(R.id.mmScore1);
        score = 0;
        timer.postDelayed(time = new Runnable() {
            @Override
            public void run() {
                    timeUP();
                }
        }, 5000);
        Score = Integer.toString(score);
        scoreView.setText(Score);
    }
    public void rightAnswer(View v) {
        score+=20;
        next.putExtra("score", score);
        startActivity(next);
        finish();
    }
    public void wrongAnswer(View v) {
        next.putExtra("score", score);
        startActivity(next);
        finish();
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to leave? Doing so will cause to reset your progress.")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exitQuiz();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    public void exitQuiz() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    public void timeUP() {
        startActivity(new Intent(this, MathMediumQuestion2.class));
        finish();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.removeCallbacksAndMessages(null);
    }
}
