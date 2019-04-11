package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion4 extends AppCompatActivity {

    int score;
    String Score,Time;
    Intent forward;
    long time = 10000;
    TextView TimeView;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question4);

        forward = new Intent(this, MathMediumQuestion5.class);
        TextView scoreView = findViewById(R.id.mmScore4);
        TimeView = findViewById(R.id.time4);
        timeUpdate();
        Intent battle = getIntent();
        score = battle.getIntExtra("scoreVal", 0);
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
    public void correctAnsw(View v) {
        score += 20;
        forward.putExtra("scoreVal", score);
        startActivity(forward);
        timer.cancel();
        finish();
    }
    public void incorrectAnsw(View v) {
        forward.putExtra("scoreVal", score);
        startActivity(forward);
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
        TimeView.setText(Time);
    }
    public void timeUP() {
        startActivity(new Intent(this, MathMediumQuestion5.class));
        timer.cancel();
        finish();
    }
}