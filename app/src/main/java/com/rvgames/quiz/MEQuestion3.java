package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MEQuestion3 extends AppCompatActivity {
    int score;
    String Score;
    Intent forward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mequestion3);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        forward = new Intent(this, MEQuestion4.class);
        Intent ahead = getIntent();
        score = ahead.getIntExtra("scoreVal", 0);
        TextView scoreValue = findViewById(R.id.meScore3);
        Score = Integer.toString(score);
        scoreValue.setText(Score);
    }
    public void selectFalse(View op1) {
        forward.putExtra("scoreVal", score);
        startActivity(forward);
        finish();
    }
    public void selectTrue(View op2) {
        score+=20;
        forward.putExtra("scoreVal", score);
        startActivity(forward);
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
