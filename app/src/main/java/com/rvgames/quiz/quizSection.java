package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class quizSection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_section);
    }
    public void Maths (View maths){
        Intent math = new Intent(this, selectDifficulty.class);
        startActivity(math);
    }
    public void Anime (View animE) {
        Intent anime = new Intent(this, SelectDifficultyAnime.class);
        startActivity(anime);
    }
}
