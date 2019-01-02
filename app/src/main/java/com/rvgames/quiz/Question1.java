package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Question1 extends AppCompatActivity {
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        TextView scoreValue = findViewById(R.id.textView4);
        String Score = Integer.toString(score);
        scoreValue.setText(Score);
    }
    public void clickTrue(View True) {
        Intent ClickTrue = new Intent(this, Question2.class);
        ClickTrue.putExtra("scoreValue", score);
        startActivity(ClickTrue);
    }
    public void clickFalse(View False) {
        Intent ClickFalse = new Intent(this, Question2.class);
        score = score + 1;
        ClickFalse.putExtra("scoreValue", score);
        startActivity(ClickFalse);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}
