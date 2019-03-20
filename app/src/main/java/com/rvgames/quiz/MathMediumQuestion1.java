package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion1 extends AppCompatActivity {
    int score;
    long timeLeft = 5000;
    String Score,TIMER;
    Intent next;
    TextView TimeLeft;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question1);

        next = new Intent(this, MathMediumQuestion2.class);
        TimeLeft = findViewById(R.id.time1);
        TIMER = Long.toString(timeLeft/1000);
        TimeLeft.setText(TIMER);
        TextView scoreView = findViewById(R.id.mmScore1);
        score = 0;
        timer = new CountDownTimer(timeLeft, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                timeUpdate();
            }

            @Override
            public void onFinish() {
                timeUP();
            }
        }.start();
        Score = Integer.toString(score);
        scoreView.setText(Score);
    }
    public void timeUpdate() {
        TIMER = Long.toString((long) timeLeft/1000);
        TimeLeft.setText(TIMER);
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
        timer.cancel();
    }
}
