package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Objects;

public class Question1 extends AppCompatActivity {
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        TextView scoreValue = findViewById(R.id.textView4);
        String Score = Integer.toString(score);
        scoreValue.setText(Score);
    }
    public void clickTrue(View True) {
        Intent ClickTrue = new Intent(this, Question2.class);
        ClickTrue.putExtra("scoreValue", score);
        startActivity(ClickTrue);
        Question1.this.finish();
    }
    public void clickFalse(View False) {
        Intent ClickFalse = new Intent(this, Question2.class);
        score = score + 1;
        ClickFalse.putExtra("scoreValue", score);
        startActivity(ClickFalse);
        Question1.this.finish();
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
