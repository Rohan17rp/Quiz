package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Question2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        Intent ClickTrue = getIntent();
        int scoreVal1 = ClickTrue.getIntExtra("scoreValue",0);
        Intent ClickFalse = getIntent();
        int scoreVal2 = ClickFalse.getIntExtra("scoreValue",0);
        TextView scoreValue = findViewById(R.id.textView6);
        if (scoreVal1 < scoreVal2) {
            String Score = Integer.toString(scoreVal2);
            scoreValue.setText(Score);
        } else {
            String Score = Integer.toString(scoreVal1);
            scoreValue.setText(Score);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
