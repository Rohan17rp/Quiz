package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Question1 extends AppCompatActivity {
    int score = 0;
    Intent next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        TextView scoreValue = findViewById(R.id.meScore1);
        String Score = Integer.toString(score);
        scoreValue.setText(Score);
        next = new Intent(this, Question2.class);
    }
    public void clickTrue(View True) {
        next.putExtra("scoreVal", score);
        startActivity(next);
        finish();
    }
    public void clickFalse(View False) {
        score+=20;
        next.putExtra("scoreVal", score);
        startActivity(next);
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
                      goBack();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    public void goBack() {
        Question1.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        Question1.this.finish();
    }
}
