package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Instruction extends AppCompatActivity {

    int i;
    String[] rule;
    TextView rules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        rules = findViewById(R.id.textViewRule);
        rule = new String[3];
        rule[0] = "\tIn difficulty easy there is no time limit.\n\n\tFor every correct answer you will be awarded 20 points.\n\n\tThere is no negative marking.";
        rule[1] = "\tIn difficulty medium there is time limit of 5 seconds per question.\n\n\tFor every correct answer you will be awarded 20 points.\n\n\tThere is no negative marking.";
        rule[2] = "\tIn difficulty medium there is time limit of 5 seconds per question.\n\n\tFor every correct answer you will be awarded 20 points.\n\n\tFor every wrong answer 20 points will be reduced.";
        i = 0;
        rules.setText(rule[i]);
    }
    public void pressNext(View view) {
        if(i < 2) {
            i++;
            rules.setText(rule[i]);
        }
    }
    public void pressPrevious(View view) {
        if(i > 0) {
            i--;
            rules.setText(rule[i]);
        }
    }
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
