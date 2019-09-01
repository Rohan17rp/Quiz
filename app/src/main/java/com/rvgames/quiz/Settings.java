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
    View layout;
    AlertDialog themeSelector;
    Context context;
    final Handler handler = new Handler();
    final ThemeMachine themeMachine = new ThemeMachine();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();

        context = getBaseContext();
        layout = findViewById(R.id.settings);
        themeMachine.setTheme(context, layout);

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
    public void selectTheme(View v) {
        handler.postDelayed(r, 500);
    }

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
                                button.setText(themeName[item]);
                                editor.putInt("themeSelectNo", item);
                                editor.commit();
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

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
