package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MathMediumQuestion4 extends AppCompatActivity {

    int score;
    String Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question4);
        TextView scoreView = findViewById(R.id.mmScore4);
        Intent plus = getIntent();
        int scoreVal1 = plus.getIntExtra("scoreVal", 0);
        Intent none = getIntent();
        int scoreVal2 = none.getIntExtra("scoreVal", 0);
        if(scoreVal1 > scoreVal2) {
            score = scoreVal1;
        } else {
            score = scoreVal2;
        }
        Score = Integer.toString(score);
        scoreView.setText(Score);
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
}
