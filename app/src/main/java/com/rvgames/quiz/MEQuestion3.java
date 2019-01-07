package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class MEQuestion3 extends AppCompatActivity {
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mequestion3);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        TextView scoreValue = findViewById(R.id.textView13);
        Intent Opt1 = getIntent();
        int scoreVal1 = Opt1.getIntExtra("scoreVal",0);
        Intent Opt2 = getIntent();
        int scoreVal2 = Opt2.getIntExtra("scoreVal",0);
        Intent Opt3 = getIntent();
        int scoreVal3 = Opt3.getIntExtra("scoreVal",0);
        Intent Opt4 = getIntent();
        int scoreVal4 = Opt4.getIntExtra("scoreVal",0);
        if ( scoreVal2 > scoreVal1 && scoreVal2 > scoreVal3 && scoreVal2 > scoreVal4 ) {
            score = scoreVal2;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        } else {
            score = scoreVal1;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        }
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to leave? Doing so will cause to reset your progress.")
                .setCancelable(false)
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
        MEQuestion3.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        MEQuestion3.this.finish();
    }
}
