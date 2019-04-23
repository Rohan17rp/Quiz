package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SelectDifficultyAnime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty_anime);
    }
    public void selectEasy (View que1) {
        startActivity(new Intent(this, AnimeEasy.class));
        SelectDifficultyAnime.this.finish();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, quizSection.class));
        SelectDifficultyAnime.this.finish();
    }
}
