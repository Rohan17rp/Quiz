package com.rvgames.quiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class Settings extends AppCompatActivity {

    Button button;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    CharSequence[] themeName;
    int theme;
    View layout;
    AlertDialog themeSelector;

    final Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            int themeSelected = pref.getInt("themeSelectNo", -1);
            AlertDialog.Builder box = new AlertDialog.Builder(Settings.this);
            box
                    .setTitle("SelectTheme")
                    .setSingleChoiceItems(themeName, themeSelected, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            switch (item) {
                                case 1:
                                    layout.setBackgroundResource(R.drawable.meliodas);
                                    break;
                                case 2:
                                    layout.setBackgroundResource(R.drawable.broly);
                                    break;
                                case 3:
                                    layout.setBackgroundResource(R.drawable.rem);
                                    break;
                                case 4:
                                    layout.setBackgroundResource(R.drawable.rimuru);
                                    break;
                                default:
                                    layout.setBackgroundResource(R.drawable.splash);
                            }
                            try {
                                theme = item;
                                button.setText(themeName[item]);
//                                getThemePreference(item);
                            } catch (RuntimeException e) {
                                e.printStackTrace();
                                Log.d("Error", "Error");
                            }
                            themeSelector.dismiss();
                        }
                    })
                    .setCancelable(true);
            themeSelector = box.create();
            themeSelector.show();
        }
    };

//    final Settings themeSettings = new Settings();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        layout = findViewById(R.id.settings);
        themeName = new CharSequence[5];
        themeName[0] = "Default";
        themeName[1] = "Meliodas";
        themeName[2] = "Broly";
        themeName[3] = "Rem";
        themeName[4] = "Rimuru";
        button = findViewById(R.id.themeSelector);
        pref = this.getSharedPreferences("theme_preference", Context.MODE_PRIVATE);
        editor = pref.edit();
    }
    public void getThemePreference(int item) {
        editor.putInt("themeSelectNo", item);
        editor.commit();
    }
    public void selectTheme(View v) {
        handler.postDelayed(r, 500);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getThemePreference(theme);
            }
        }, 50);
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
