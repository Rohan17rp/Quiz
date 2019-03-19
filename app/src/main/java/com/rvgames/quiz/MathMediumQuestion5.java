package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion5 extends AppCompatActivity {

    int score;
    String Score;
    Handler timer;
    Intent last;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question5);

        last = new Intent(this, MathMediumQuizEnd.class);
        timer = new Handler();
        TextView scoreView = findViewById(R.id.mmScore5);
        Intent forward = getIntent();
        score = forward.getIntExtra("scoreVal", 0);
        Score = Integer.toString(score);
        scoreView.setText(Score);
        timer.postDelayed(new Runnable() {
            @Override
            public void run() {
                timeUP();
            }
        }, 5000);
    }
    public void AnswerCorrect(View v) {
        score += 20;
        last.putExtra("scoreVal", score);
        startActivity(last);
        finish();
    }
    public void AnswerWrong(View v) {
        last.putExtra("scoreVal", score);
        startActivity(last);
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
        startActivity(new Intent(this, MathMediumQuizEnd.class));
        finish();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.removeCallbacksAndMessages(null);
    }
}