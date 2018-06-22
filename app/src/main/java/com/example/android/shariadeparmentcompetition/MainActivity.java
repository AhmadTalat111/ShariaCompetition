package com.example.android.shariadeparmentcompetition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    int score = 0;
    private int questionOneScore = 0;
    private int questionTwoScore = 0;
    private int questionThreeScore = 0;
    private int questionFourScore = 0;
    private int questionFiveScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getWindow().getDecorView().getLayoutDirection() == View.LAYOUT_DIRECTION_LTR) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        setContentView(R.layout.activity_main);


    }


    public void scoreUpdate(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        name.getText().toString();
        CheckBox q1check_a = (CheckBox) findViewById(R.id.q1check_a);
        boolean q1a = q1check_a.isChecked();
        CheckBox q1check_b = (CheckBox) findViewById(R.id.q1check_b);
        boolean q1b = q1check_b.isChecked();
        CheckBox q1check_c = (CheckBox) findViewById(R.id.q1check_c);
        boolean q1c = q1check_c.isChecked();
        calculateScore1(q1a, q1b, q1c);
        RadioButton q2_a = (RadioButton) findViewById(R.id.q2_a);
        boolean q2a = q2_a.isChecked();
        RadioButton q2_b = (RadioButton) findViewById(R.id.q2_b);
        boolean q2b = q2_b.isChecked();
        RadioButton q2_c = (RadioButton) findViewById(R.id.q2_c);
        boolean q2c = q2_c.isChecked();
        calculateScore2(q2b, q2a, q2c);
        CheckBox q3check_a = (CheckBox) findViewById(R.id.q3_a);
        boolean q3a = q3check_a.isChecked();
        CheckBox q3check_b = (CheckBox) findViewById(R.id.q3_b);
        boolean q3b = q3check_b.isChecked();
        CheckBox q3check_c = (CheckBox) findViewById(R.id.q3_c);
        boolean q3c = q3check_c.isChecked();
        calculateScore3(q3a, q3b, q3c);
        RadioButton q4_a = (RadioButton) findViewById(R.id.q4_a);
        boolean q4a = q4_a.isChecked();
        calculateScore4(q4a);
        RadioButton q5_c = (RadioButton) findViewById(R.id.q5_c);
        boolean q5c = q5_c.isChecked();
        calculateScore5(q5c);
        finalScore();
        Toast toast = Toast.makeText(this, name.getText().toString() + " scored " + score, Toast.LENGTH_LONG);
        toast.show();
    }

    private void calculateScore1(boolean hasBeenCheckedq1a, boolean hasBeenCheckedq1b, boolean hasBeenCheckedq1c) {

        if (hasBeenCheckedq1a && hasBeenCheckedq1b && hasBeenCheckedq1c && questionOneScore == 0) {
            questionOneScore += 5;
        }
        if (hasBeenCheckedq1a && hasBeenCheckedq1b && hasBeenCheckedq1c && questionOneScore == 5) {
            questionOneScore = 5;
        } else {
            questionOneScore = 0;
        }

    }

    private void calculateScore2(boolean q2b, boolean q2a, boolean q2c) {
        if (q2b && questionTwoScore == 0) {
            questionTwoScore += 5;
        }
        if (q2b && questionTwoScore == 5 && !q2a && !q2c) {
            questionTwoScore = 5;
        } else {
            questionTwoScore = 0;
        }
    }

    private void calculateScore3(boolean q3a, boolean q3b, boolean q3c) {
        if (q3a && q3b && questionThreeScore == 0 && !q3c) {
            questionThreeScore += 5;

        }
        if (q3a && q3b && questionThreeScore == 5 && !q3c) {
            questionThreeScore = 5;
        } else {
            questionThreeScore = 0;
        }

    }

    private void calculateScore4(boolean q4a) {
        if (q4a && questionFourScore == 0) {
            questionFourScore += 5;
        }
        if (q4a && questionFourScore == 5) {
            questionFourScore = 5;
        } else {
            questionFourScore = 0;
        }
        Log.d(TAG, "calculateScore4: " + questionFourScore);

    }

    private void calculateScore5(boolean q5c) {
        if (q5c && questionFiveScore == 0) {
            questionFiveScore += 5;
        }
        if (q5c && questionFiveScore == 5) {
            questionFiveScore = 5;
        } else {
            questionFiveScore = 0;
        }

    }

    private void finalScore() {
        score = questionOneScore + questionTwoScore + questionThreeScore + questionFourScore + questionFiveScore;
    }
}




