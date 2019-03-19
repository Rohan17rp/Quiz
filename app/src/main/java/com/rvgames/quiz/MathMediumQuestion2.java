package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MathMediumQuestion2 extends AppCompatActivity {

    int score;
    String Score;
    Handler handler;
    Runnable time;
    Intent go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_medium_question2);

        go = new Intent(this, MathMediumQuestion3.class);
        TextView scoreView = findViewById(R.id.mmScore2);
        Intent next = getIntent();
        score = next.getIntExtra("score", 0);
        Score = Integer.toString(score);
        scoreView.setText(Score);
        handler = new Handler();
        handler.postDelayed(time = new Runnable() {
            @Override
            public void run() {
                timeUP();
            }
        },5000);
    }
    public void correctAns(View view) {
        score += 20;
        go.putExtra("scoreVal", score);
        startActivity(go);
        finish();
    }
    public void wrongAns(View view) {
        go.putExtra("scoreVal", score);
        startActivity(go);
        finish();
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to leave? Doing so will cause to reset your progress.")
                .setCancelable(true)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        exitQuiz();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
    public void exitQuiz() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
    public void timeUP() {
        startActivity(new Intent(this, MathMediumQuestion3.class));
        finish();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
