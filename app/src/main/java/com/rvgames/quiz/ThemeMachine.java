package com.rvgames.quiz;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThemeMachine extends AppCompatActivity {
    public void setTheme(Context context, View view) {
        SharedPreferences preferences;
        preferences = context.getSharedPreferences("theme_preference", Context.MODE_PRIVATE);
        int theme = preferences.getInt("themeSelectNo", -1);
        switch (theme) {
            case 1:
                view.setBackgroundResource(R.drawable.meliodas);
                break;
            case 2:
                view.setBackgroundResource(R.drawable.broly);
                break;
            case 3:
                view.setBackgroundResource(R.drawable.rem);
                break;
            case 4:
                view.setBackgroundResource(R.drawable.rimuru);
                break;
            default:
                view.setBackgroundResource(R.drawable.splash);
        }
    }
}
