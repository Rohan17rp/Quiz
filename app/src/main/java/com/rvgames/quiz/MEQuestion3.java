package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MEQuestion3 extends AppCompatActivity {
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mequestion3);

        TextView scoreValue = findViewById(R.id.meScore3);
        Intent right = getIntent();
        int scoreValR = right.getIntExtra("scoreVal",0);
        Intent wrong = getIntent();
        int scoreValW = wrong.getIntExtra("scoreVal",0);
        if ( scoreValR > scoreValW ) {
            score = scoreValR;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        } else {
            score = scoreValW;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        }
    }
    public void selectFalse(View op1) {
        Intent SelectOptW = new Intent(this, MEQuestion4.class);
        SelectOptW.putExtra("scoreVal", score);
        startActivity(SelectOptW);
        finish();
    }
    public void selectTrue(View op2) {
        Intent SelectOptR = new Intent(this, MEQuestion4.class);
        score = score + 1;
        SelectOptR.putExtra("scoreVal", score);
        startActivity(SelectOptR);
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
        MEQuestion3.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        MEQuestion3.this.finish();
    }
}
