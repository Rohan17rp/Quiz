package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class selectDifficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
    }
    public void startEasyQuiz(View easy) {
        Intent que1 = new Intent(this, Question1.class);
        startActivity(que1);
        selectDifficulty.this.finish();
    }
     @Override
     public void onBackPressed() {
        startActivity(new Intent(this, quizSection.class));
        selectDifficulty.this.finish();
     }
}
