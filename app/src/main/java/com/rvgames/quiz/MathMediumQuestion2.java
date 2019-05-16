package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion2 extends AppCompatActivity {

    int score;
    long timeLeft = 10000;
    String Score, Time;
    Intent go;
    CountDownTimer timer;
    TextView timeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question2);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        go = new Intent(this, MathMediumQuestion3.class);
        TextView scoreView = findViewById(R.id.mmScore2);
        timeView = findViewById(R.id.time2);
        timeUpdate();
        Intent next = getIntent();
        score = next.getIntExtra("score", 0);
        Score = Integer.toString(score);
        scoreView.setText(Score);
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
    }
    public void correctAns(View view) {
        score += 20;
        go.putExtra("scoreVal", score);
        startActivity(go);
        timer.cancel();
        finish();
    }
    public void wrongAns(View view) {
        go.putExtra("scoreVal", score);
        startActivity(go);
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
        Time = Long.toString((long) timeLeft/1000);
        timeView.setText(Time);
    }
    public void timeUP() {
        startActivity(new Intent(this, MathMediumQuestion3.class));
        timer.cancel();
        finish();
    }
}
