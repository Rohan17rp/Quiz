package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MEQuestion3 extends AppCompatActivity {
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mequestion3);

        TextView scoreValue = findViewById(R.id.textView13);
        Intent Opt1 = getIntent();
        int scoreVal1 = Opt1.getIntExtra("scoreVal",0);
        Intent Opt2 = getIntent();
        int scoreVal2 = Opt2.getIntExtra("scoreVal",0);
        Intent Opt3 = getIntent();
        int scoreVal3 = Opt3.getIntExtra("scoreVal",0);
        Intent Opt4 = getIntent();
        int scoreVal4 = Opt4.getIntExtra("scoreVal",0);
        if ( scoreVal2 > scoreVal1 && scoreVal2 > scoreVal3 && scoreVal2 > scoreVal4 ) {
            score = scoreVal2;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        } else {
            score = scoreVal1;
            String Score = Integer.toString(score);
            scoreValue.setText(Score);
        }
    }
    public void selectOpt1(View op1) {
        Intent SelectOpt1 = new Intent(this, MEQuestion4.class);
        SelectOpt1.putExtra("scoreVal", score);
        startActivity(SelectOpt1);
        finish();
    }
    public void selectOpt2(View op2) {
        Intent SelectOpt2 = new Intent(this, MEQuestion4.class);
        score = score + 1;
        SelectOpt2.putExtra("scoreVal", score);
        startActivity(SelectOpt2);
        finish();
    }
    public void selectOpt3(View op3) {
        Intent SelectOpt3 = new Intent(this, MEQuestion4.class);
        SelectOpt3.putExtra("scoreVal", score);
        startActivity(SelectOpt3);
        finish();
    }
    public void selectOpt4(View op4) {
        Intent SelectOpt4 = new Intent(this, MEQuestion4.class);
        SelectOpt4.putExtra("scoreVal",score);
        startActivity(SelectOpt4);
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
        MEQuestion3.super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        MEQuestion3.this.finish();
    }
}
