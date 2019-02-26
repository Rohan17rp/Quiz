package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnimeEasyQuestion2 extends AppCompatActivity {

    int score;
    String Score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_easy_question2);

        TextView scoreView = findViewById(R.id.aeScore2);
        Intent sendPlus = getIntent();
        int scoreValR = sendPlus.getIntExtra("score", 0);
        Intent sendMinus = getIntent();
        int scoreValW = sendMinus.getIntExtra("score", 0);
        if(scoreValR > scoreValW) {
            score = scoreValR;
        } else {
            score = scoreValW;
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
                        exit();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    public void exit() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
