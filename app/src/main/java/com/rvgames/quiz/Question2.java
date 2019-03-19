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
    String Score;
    Intent ahead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        ahead = new Intent(this, MEQuestion3.class);
        TextView scoreValue = findViewById(R.id.meScore2);
        Intent next = getIntent();
        score = next.getIntExtra("scoreVal", 0);
        Score = Integer.toString(score);
        scoreValue.setText(Score);
    }
    public void selectWrongAns(View cross) {
        ahead.putExtra("scoreVal", score);
        startActivity(ahead);
        finish();
    }
    public void selectRightAns(View tick) {
        score+=20;
        ahead.putExtra("scoreVal", score);
        startActivity(ahead);
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
