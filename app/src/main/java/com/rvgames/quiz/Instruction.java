package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Instruction extends AppCompatActivity {

    int i;
    String[] rule;
    TextView rules;
    Button previous, next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        previous = findViewById(R.id.button34);
        next = findViewById(R.id.button36);
        rules = findViewById(R.id.textViewRule);
        rule = new String[3];
        rule[0] = "\tIn difficulty easy there is no time limit.\n\n\tFor every correct answer you will be awarded 20 points.\n\n\tThere is no negative marking.";
        rule[1] = "\tIn difficulty medium there is time limit of 10 seconds per question.\n\n\tFor every correct answer you will be awarded 20 points.\n\n\tThere is no negative marking.";
        rule[2] = "\tIn difficulty hard there is time limit of 10 seconds per question.\n\n\tFor every correct answer you will be awarded 20 points.\n\n\tFor every wrong answer 10 points will be reduced.";
        i = 0;
        rules.setText(rule[i]);
        previous.setVisibility(View.INVISIBLE);
    }

    public void pressNext(View view) {
        if (i < 2) {
            i++;
            rules.setText(rule[i]);
        }
        if (i > 0) {
            previous.setVisibility(View.VISIBLE);
        }
        if(i == 2) {
            next.setVisibility(View.INVISIBLE);
        }
    }

    public void pressPrevious(View view) {
        if (i > 0) {
            i--;
            rules.setText(rule[i]);
        }
        if(i < 2) {
            next.setVisibility(View.VISIBLE);
        }
        if(i == 0) {
            previous.setVisibility(View.INVISIBLE);
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}