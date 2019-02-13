package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        Intent ClickTrue = getIntent();
        int scoreVal1 = ClickTrue.getIntExtra("scoreValue",0);
        Intent ClickFalse = getIntent();
        int scoreVal2 = ClickFalse.getIntExtra("scoreValue",0);
        TextView scoreValue = findViewById(R.id.meScore2);
        if (scoreVal1 < scoreVal2) {
            score = scoreVal2;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        } else {
            score = scoreVal1;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        }
    }
    public void selectWrongAns(View cross) {
        Intent right = new Intent(this, MEQuestion3.class);
        right.putExtra("scoreVal", score);
        startActivity(right);
        finish();
    }
    public void selectRightAns(View tick) {
        Intent wrong = new Intent(this, MEQuestion3.class);
        score+=20;
        wrong.putExtra("scoreVal", score);
        startActivity(wrong);
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
                .setNegativeButton("No", null)
                .show();
    }
    public void exitQuiz() {
        Question2.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        Question2.this.finish();
    }
}
