package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion3 extends AppCompatActivity {

    int score;
    String Score;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question3);

        handler = new Handler();
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
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timeUP();
            }
        }, 5000);
    }
    public void rightAns(View view) {
        score += 20;
        Intent plus = new Intent(this, MathMediumQuestion4.class);
        plus.putExtra("scoreVal", score);
        startActivity(plus);
        finish();
    }
    public void wrongAns(View view) {
        Intent none = new Intent(this, MathMediumQuestion4.class);
        none.putExtra("scoreVal", score);
        startActivity(none);
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
        startActivity(new Intent(this, MathMediumQuestion4.class));
        finish();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
