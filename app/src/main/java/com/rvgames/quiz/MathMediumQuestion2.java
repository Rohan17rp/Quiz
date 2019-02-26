package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MathMediumQuestion2 extends AppCompatActivity {

    int score;
    String Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question2);

        TextView scoreView = findViewById(R.id.mmScore2);
        Intent RightAns = getIntent();
        int scoreval1 = RightAns.getIntExtra("score", 0);
        Intent WrongAns = getIntent();
        int scoreval2 = WrongAns.getIntExtra("score", 0);
        if(scoreval1 > scoreval2) {
            score = scoreval1;
        } else {
            score = scoreval2;
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
