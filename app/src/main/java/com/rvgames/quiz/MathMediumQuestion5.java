package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion5 extends AppCompatActivity {

    int score;
    String Score,Time;
    Intent last;
    long time = 10000;
    TextView timeView;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question5);

        last = new Intent(this, MathMediumQuizEnd.class);
        TextView scoreView = findViewById(R.id.mmScore5);
        timeView = findViewById(R.id.time5);
        timeUpdate();
        Intent forward = getIntent();
        score = forward.getIntExtra("scoreVal", 0);
        timer = new CountDownTimer(time, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                time = millisUntilFinished;
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
    public void AnswerCorrect(View v) {
        score += 20;
        last.putExtra("scoreVal", score);
        startActivity(last);
        timer.cancel();
        finish();
    }
    public void AnswerWrong(View v) {
        last.putExtra("scoreVal", score);
        startActivity(last);
        timer.cancel();
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
        timer.cancel();
        finish();
    }
    public void timeUpdate() {
        Time = Long.toString(time/1000);
        timeView.setText(Time);
    }
    public void timeUP() {
        startActivity(new Intent(this, MathMediumQuizEnd.class));
        timer.cancel();
        finish();
    }
}