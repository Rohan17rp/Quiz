package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AnimeEasy extends AppCompatActivity {

    int score, qno;
    String Score;
    int[] questions = new int[5];
    int[] scoreViewId = new int[5];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        qno = 0;
        score = 0;

        questions[0] = R.layout.activity_anime_easy_question1;
        questions[1] = R.layout.activity_anime_easy_question2;
        questions[2] = R.layout.anime_easy_question3;
        questions[3] = R.layout.anime_easy_question4;
        questions[4] = R.layout.anime_easy_question_5;
        setContentView(questions[qno]);

        scoreViewId[0] = R.id.aeScore1;
        scoreViewId[1] = R.id.aeScore2;
        scoreViewId[2] = R.id.aeScore3;
        scoreViewId[3] = R.id.aeScore4;
        scoreViewId[4] = R.id.aeScore5;

        scoreUpdate();
    }
    public void ClickRight(View v) {
        score+=20;
        nextQuestion();
    }
    public void ClickWrong(View v) {
        nextQuestion();
    }
    public void nextQuestion() {
        qno++;
        if(qno < 5) {
            setContentView(questions[qno]);
            scoreUpdate();
        } else {
            endQuiz();
        }
    }
    public void scoreUpdate() {
        TextView scoreView = findViewById(scoreViewId[qno]);
        Score = Integer.toString(score);
        scoreView.setText(Score);
    }
    public void endQuiz() {
        Intent end = new Intent(this, AnimeEasyEnd.class);
        end.putExtra("score", score);
        startActivity(end);
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
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
