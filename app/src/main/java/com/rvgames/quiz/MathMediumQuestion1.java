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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question1);

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
        Intent RightAns = new Intent(this, MathMediumQuestion2.class);
        score+=20;
        RightAns.putExtra("score", score);
        startActivity(RightAns);
        finish();
    }
    public void wrongAnswer(View v) {
        Intent WrongAns = new Intent(this, MathMediumQuestion2.class);
        WrongAns.putExtra("score", score);
        startActivity(WrongAns);
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
