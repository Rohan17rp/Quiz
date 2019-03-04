package com.rvgames.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MathsScores extends AppCompatActivity {

    int E,M,H;
    String easy, medium, hard;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_scores);

        TextView MEH = findViewById(R.id.MEFHS);
        TextView MMH = findViewById(R.id.MMFHS);
        TextView MHH = findViewById(R.id.MHFHS);

        pref = this.getSharedPreferences("myPrefKeys", Context.MODE_PRIVATE);
        E = pref.getInt("MEhighscore", 0);
        M = pref.getInt("MMhighscore", 0);
        H = pref.getInt("MHhighscore", 0);

        easy = Integer.toString(E);
        medium = Integer.toString(M);
        hard = Integer.toString(H);

        MEH.setText(easy);
        MMH.setText(medium);
        MHH.setText(hard);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HighScore.class));
        finish();
    }
}
