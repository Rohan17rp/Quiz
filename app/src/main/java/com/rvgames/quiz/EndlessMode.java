package com.rvgames.quiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class EndlessMode extends AppCompatActivity {

        /*  Declarations    */
        int streak_int, operation, correct_option, highscore_int;
        String streak_string, highscore_string;
        Intent repeat;
        int number1, number2;
        String string_number1, string_number2;
        Button[] option = new Button[4];
        SharedPreferences sharedPreferences_streak, sharedPreferences_highscore;
        TextView streakValue, highscoreValue;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.endless_mode);
            /*  Launch same Activity again  */
            repeat = new Intent(this, EndlessMode.class);
            /*  Declaring TextView */
            streakValue = findViewById(R.id.streak);
            highscoreValue = findViewById(R.id.highScoreEndless);
            /*  Declare preferences */
            sharedPreferences_streak = this.getSharedPreferences("streakVal", streak_int);
            sharedPreferences_highscore = this.getSharedPreferences("HighScoreVal", highscore_int);
            /*  Get previously stored value of streak   */
            streak_int = sharedPreferences_streak.getInt("streakVal", 0);
            highscore_int = sharedPreferences_highscore.getInt("HighScoreVal", 0);

            streak_string = Integer.toString(streak_int);
            highscore_string = Integer.toString(highscore_int);
            streakValue.setText(streak_string);
            highscoreValue.setText(highscore_string);

            /*  Set Question And Answer */
            getNumbers();
            operation = printQuestion(string_number1,string_number2);
            declareOptions();
            correct_option = setOptions(operation);

        }
        /*  Function That sets streak zero on wrong answer  */
        public void setStreak_intZero(View cross) {
            streak_int  = 0;
            streakValue.setText(streak_string);
            sharedPreferences_streak.edit().putInt("streakVal", streak_int).apply();
            startActivity(repeat);
            finish();
        }

        /*  Function That increments streak on correct answer   */
        public void setStreak_int(View tick) {
            streak_int += 1;
            streakValue.setText(streak_string);
            sharedPreferences_streak.edit().putInt("streakVal", streak_int).apply();
            repeat.putExtra("scoreVal", streak_int);
            startActivity(repeat);
            finish();
        }

        /*  Declare two numbers and strings for framing question    */
        public void getNumbers(){
            Random random_number1 = new Random() , random_number2 = new Random();
            number1 = random_number1.nextInt(10);
            number2 = random_number2.nextInt(10);
            string_number1 = Integer.toString(number1);
            string_number2 = Integer.toString(number2);
        }

        /*  Print the question statement    */
        public int printQuestion(String a, String b){
            TextView Question = findViewById(R.id.Question);
            String question;
            int operator;
            Random random_operator = new Random();
            operator = random_operator.nextInt(3);
            switch (operator) {
                case 0: question = a.concat(" + ").concat(b);
                        break;
                case 1: question = a.concat(" - ").concat(b);
                        break;
                case 2: question = a.concat(" * ").concat(b);
                        break;
                default:question = a.concat(" + ").concat(b);
            }
            Question.setText(question);
            return operator;
        }

        /*  Find answer for addition    */
        public int setNumber_add(){
            return number1 + number2;
        }

        /*  Find answer for multiplication    */
        public int setNumber_product(){
            return number1 * number2;
        }

        /*  Find answer for subtraction    */
        public int setNumber_subtraction(){
            return number1 - number2;
        }

        /*  Set 4 options   */
        public int setOptions(int operation){
            int sum, product, subtraction;
            sum = setNumber_add();
            product = setNumber_product();
            subtraction = setNumber_subtraction();
            int switch_var;
            String ans_option;
            switch (operation) {
                case 0: ans_option = Integer.toString(sum);
                        break;
                case 1: ans_option = Integer.toString(subtraction);
                        break;
                case 2: ans_option = Integer.toString(product);
                        break;
                default:ans_option = Integer.toString(sum);
                        break;
            }
            Random random = new Random();
            switch_var = random.nextInt(4);
            option[switch_var].setText(ans_option);
            setWrongOptions(switch_var);
            return Integer.parseInt(ans_option);
        }

        /*  Declaring option buttons    */
        public void declareOptions(){
            option[0] = findViewById(R.id.option1);
            option[1] = findViewById(R.id.option2);
            option[2] = findViewById(R.id.option3);
            option[3] = findViewById(R.id.option4);

        }

        /*  Check answer and call respective functions  */
        public void checkAns(View check){
            Button button;
            String choice_string;
            int choice_int;
            button = findViewById(check.getId());
            choice_string = (String) button.getText();
            choice_int = Integer.parseInt(choice_string);
            if(choice_int == correct_option){
                setStreak_int(null);
            }
            else {
                setStreak_intZero(null);
            }
            getHighscore();
        }

        /*  set 3 wrong options */
        public void setWrongOptions(int rightOption){
            Random random = new Random();
            String wrongChoice_string;
            int wrongChoice_int, random_adder;
            for (int i = 0; i < 4; i++){
                if(i != rightOption){
                    Boolean add_sub = random.nextBoolean();
                    do{
                        random_adder = random.nextInt(10);
                    }while (random_adder == 0);
                    if(add_sub){
                        wrongChoice_int = random_adder + setNumber_add();
                    }
                    else {
                        wrongChoice_int = random_adder - setNumber_add();
                    }
                    wrongChoice_string = Integer.toString(wrongChoice_int);
                    option[i].setText(wrongChoice_string);
                }
            }
        }

        public void getHighscore(){
            if(streak_int > highscore_int){
                highscore_int = streak_int;
            }
            sharedPreferences_highscore.edit().putInt("HighScoreVal", highscore_int).apply();
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
            sharedPreferences_streak.edit().putInt("streakVal", 0).apply();
            EndlessMode.super.onBackPressed();
            startActivity(new Intent(this, MainActivity.class));
            EndlessMode.this.finish();
        }
}
