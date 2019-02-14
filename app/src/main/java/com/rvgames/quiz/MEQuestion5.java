package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MEQuestion5 extends AppCompatActivity {
    int score;
    String Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mequestion5);
        TextView scoreValue = findViewById(R.id.meScore5);
        Intent rightOpt = getIntent();
        int scoreValR = rightOpt.getIntExtra("scoreVal",0);
        Intent wrongOpt = getIntent();
        int scoreValW = wrongOpt.getIntExtra("scoreVal",0);
        if(scoreValR > scoreValW) {
            score = scoreValR;
        } else {
            score = scoreValW;
        }
        Score = Integer.toString(score);
        scoreValue.setText(Score);
    }
    public void RightAnswer(View R) {
        Intent ansR = new Intent(this, MathQuizEasyEnd.class);
        score+=20;
        ansR.putExtra("scoreValR", score);
        startActivity(ansR);
        finish();
    }
    public void WrongAnswer(View W) {
        Intent ansW = new Intent(this, MathQuizEasyEnd.class);
        ansW.putExtra("scoreValW", score);
        startActivity(ansW);
        finish();
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to leave? Doing so will cause to reset your progress.")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        exitQuiz();
                    }
                })
                .setNegativeButton("No",null)
                .show();
    }
    public void exitQuiz() {
        MEQuestion5.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        MEQuestion5.this.finish();
    }
}
