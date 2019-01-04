package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class quizSection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_section);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
    }
    public void Maths (View maths){
        Intent math = new Intent(this, selectDifficulty.class);
        startActivity(math);
        quizSection.this.finish();
    }
    public void Anime (View animE) {
        Intent anime = new Intent(this, SelectDifficultyAnime.class);
        startActivity(anime);
        quizSection.this.finish();
    }
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        quizSection.this.finish();
    }
}
