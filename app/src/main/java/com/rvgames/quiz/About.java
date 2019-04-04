package com.rvgames.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class About extends AppCompatActivity {
     String about;
    TextView ABOUT_DEV;
    protected void OnCreate(){
        ABOUT_DEV = findViewById(R.id.about);
        about = "\n All Rights of this games are reserved with rvgames.com\n Any suggesstions are most welcomed \n Current Developing Team :\n Ved Patil   - 9270453935 \n Rohan Patil - 9763847172\n";
        ABOUT_DEV.setText(about);
    }
    public void onBackpressed(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
