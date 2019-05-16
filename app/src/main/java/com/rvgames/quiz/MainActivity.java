package com.rvgames.quiz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rvgames.quiz.ThemeMachine;

public class MainActivity extends AppCompatActivity {

    View view;
    ThemeMachine themeMachine;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        themeMachine = new ThemeMachine();
        context = getBaseContext();
        try {
            view = findViewById(R.id.mainActivity);
//            themeMachine.setTheme(view);
        } catch (RuntimeException e) {
//            e.printStackTrace();
            Log.d("Error", "1");
        }
        try {
//            setTheme(view);
            themeMachine.setTheme(context, view);
        } catch (RuntimeException e) {
            Log.d("Error", "2");
            Log.e("Error", "2");
            e.printStackTrace();
        }
    }
    public void quizStart(View view) {
        Intent difficulty = new Intent(this, quizSection.class);
        startActivity(difficulty);
        MainActivity.this.finish();
    }
    public void highScore(View h) {
        Intent seeHighScore = new Intent(this, HighScore.class);
        startActivity(seeHighScore);
        finish();
    }
    public void inst(View v) {
        startActivity(new Intent(this, Instruction.class));
        finish();
    }
    public void settings(View v) {
        startActivity(new Intent(this, Settings.class));
        finish();
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No",null)
                .show();
    }
}
