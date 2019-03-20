package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion3 extends AppCompatActivity {

    int score;
    String Score,Time;
    Intent battle;
    long timeLeft = 5000;
    TextView timeView;
    CountDownTimer time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question3);

        battle = new Intent(this, MathMediumQuestion4.class);
        TextView scoreView = findViewById(R.id.mmScore3);
        timeView = findViewById(R.id.time3);
        timeUpdate();
        Intent go = getIntent();
        score = go.getIntExtra("scoreVal", 0);
        time = new CountDownTimer(5000, 1) {
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
    public void rightAns(View view) {
        score += 20;
        battle.putExtra("scoreVal", score);
        startActivity(battle);
        time.cancel();
        finish();
    }
    public void wrongAns(View view) {
        battle.putExtra("scoreVal", score);
        startActivity(battle);
        time.cancel();
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
        time.cancel();
        finish();
    }
    public void timeUpdate() {
        Time = Long.toString(timeLeft/1000);
        timeView.setText(Time);
    }
    public void timeUP() {
        startActivity(new Intent(this, MathMediumQuestion4.class));
        time.cancel();
        finish();
    }
}
