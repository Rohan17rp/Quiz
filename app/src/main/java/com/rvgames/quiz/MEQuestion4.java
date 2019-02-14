package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MEQuestion4 extends AppCompatActivity {
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mequestion4);

        TextView scoreValue = findViewById(R.id.meScore4);
        Intent SelectOptW = getIntent();
        int scoreValW = SelectOptW.getIntExtra("scoreVal", 0);
        Intent SelectOptR = getIntent();
        int scoreValR = SelectOptR.getIntExtra("scoreVal", 0);
        if (scoreValW > scoreValR) {
            score = scoreValW;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        } else {
            score = scoreValR;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        }
    }

    public void correctAnswer(View r) {
        score += 20;
        Intent rightOpt = new Intent(this, MEQuestion5.class);
        rightOpt.putExtra("scoreVal", score);
        startActivity(rightOpt);
        finish();
    }

    public void wrongAnswer(View w) {
        Intent wrongOpt = new Intent(this, MEQuestion5.class);
        wrongOpt.putExtra("scoreVal", score);
        startActivity(wrongOpt);
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
        MEQuestion4.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        MEQuestion4.this.finish();
    }
}
