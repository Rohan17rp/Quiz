package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        Intent ClickTrue = getIntent();
        int scoreVal1 = ClickTrue.getIntExtra("scoreValue",0);
        Intent ClickFalse = getIntent();
        int scoreVal2 = ClickFalse.getIntExtra("scoreValue",0);
        TextView scoreValue = findViewById(R.id.textView6);
        if (scoreVal1 < scoreVal2) {
            String Score = Integer.toString(scoreVal2);
            scoreValue.setText(Score);
        } else {
            String Score = Integer.toString(scoreVal1);
            scoreValue.setText(Score);
        }
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
