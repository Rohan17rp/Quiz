package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MathMediumQuestion3 extends AppCompatActivity {

    int score;
    String Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question3);

        TextView scoreView = findViewById(R.id.mmScore3);
        Intent yes = getIntent();
        int scoreR = yes.getIntExtra("scoreVal", 0);
        Intent no = getIntent();
        int scoreW = no.getIntExtra("scoreVal", 0);
        if(scoreR > scoreW) {
            score = scoreR;
        } else {
            score = scoreW;
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
