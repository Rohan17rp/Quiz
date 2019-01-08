package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MEQuestion4 extends AppCompatActivity {
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mequestion4);

        TextView scoreValue = findViewById(R.id.textView15);
        Intent SelectOpt1 = getIntent();
        int scoreVal1 = SelectOpt1.getIntExtra("scoreVal",0);
        Intent SelectOpt2 = getIntent();
        int scoreVal2 = SelectOpt2.getIntExtra("scoreVal",0);
        Intent SelectOpt3 = getIntent();
        int scoreVal3 = SelectOpt3.getIntExtra("scoreVal",0);
        Intent SelectOpt4 = getIntent();
        int scoreVal4 = SelectOpt4.getIntExtra("scoreVal",0);
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
        MEQuestion4.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        MEQuestion4.this.finish();
    }
}
