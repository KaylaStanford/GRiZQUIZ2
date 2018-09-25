package com.example.android.grizquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0;

    /**
     * This method is called when the SUBMIT button is clicked.
     * This is where all the classes are called to check/evaluate/calculate the quiz questions.
     */
    public void submitQuiz(View view) {


        int question1Score = checkQuestion1();

        EditText answerField5 = (EditText) findViewById(R.id.birthview);
        String answer2Text = answerField5.getText().toString();
        int questionTwoScore = checkQuestionTwo(answer2Text);

        int question3Score = checkQuestion3();

        int question4Score = checkQuestionFour();

        CheckBox madLiberationCheckBox = (CheckBox) findViewById(R.id.mad_liberation_checkbox);
        boolean hasmadLiberation = madLiberationCheckBox.isChecked();

        CheckBox goodWillPrevailCheckBox = (CheckBox) findViewById(R.id.good_will_prevail_checkbox);
        boolean hasGoodWillPrevail = goodWillPrevailCheckBox.isChecked();

        CheckBox darkSideCheckBox = (CheckBox) findViewById(R.id.dark_side_checkbox);
        boolean hasdarkSide = darkSideCheckBox.isChecked();

        CheckBox rebelEraCheckBox = (CheckBox) findViewById(R.id.rebel_era_checkbox);
        boolean hasRebelEra = rebelEraCheckBox.isChecked();

        CheckBox sayitLoudCheckBox = (CheckBox) findViewById(R.id.say_it_loud_checkbox);
        boolean hasSayitLoud = sayitLoudCheckBox.isChecked();


        int checkBoxScore = calculatecheckBoxPoints(hasmadLiberation, hasGoodWillPrevail,hasdarkSide, hasRebelEra, hasSayitLoud);


        score = question1Score + questionTwoScore + question3Score + question4Score + checkBoxScore;
        Toast.makeText(this, "You scored " + score + " out of 100 points!", Toast.LENGTH_LONG).show();

    }

    /**
     * This method checks and scores Question 1.
     * The correct answer is stored in the corect answer variable. If the button selected is equal
     * to content inside correct answer variable + 20 points is awarded.
     * @return is  either 0 or 20 points.
     */

    private int checkQuestion1() {
        int questionone = 0;
        int answer = R.id.saxophone_button;

        RadioGroup instrumentRadioGroup = (RadioGroup) findViewById(R.id.instrument_group);
        int selected = instrumentRadioGroup.getCheckedRadioButtonId();
        if (selected == answer) {
            questionone += 20;
        }

        return questionone;
    }

    /**
     * This method checks and scores Question 2.
     *
     * @param questionTwoAnswer is the input answer of Question two.
     * @return 20 points if the answer matches 1990.
     */

    private int checkQuestionTwo (String questionTwoAnswer) {
        int questionTwoPoints = 0;

        if ("1990".equals(questionTwoAnswer)) {
            questionTwoPoints = 20;
        }
        return questionTwoPoints;
    }

    /**
     * This method checks and scores Question 3.
     * The correct answer is stored in the correct answer variable. If the button selected is equal
     * to content inside correct answer variable + 20 points is awarded.
     * @return is  either 0 or 20 points.
     */

    private int checkQuestion3() {
        int questionthree = 0;
        int answer = R.id.Gemini_button;

        RadioGroup ZodiacRadioGroup = (RadioGroup) findViewById(R.id.zodiac);
        int selected = ZodiacRadioGroup.getCheckedRadioButtonId();
        if (selected == answer) {
            questionthree += 20;
        }

        return questionthree;
    }
    /**
     * This method checks and scores Question 4.
     * The correct answer is stored in the correct answer variable. If the button selected is equal
     * to content inside correct answer variable + 20 points is awarded.
     * @return is  either 0 or 20 points.
     */
    private int checkQuestionFour() {
        int questionFourPoints = 0;
        int answer = R.id.Michigan_button;

        RadioGroup StateRadioGroup = (RadioGroup) findViewById(R.id.State);
        int selected = StateRadioGroup.getCheckedRadioButtonId();
        if (selected == answer) {
            questionFourPoints += 20;
        }

        return questionFourPoints;
    }


    /**
     * This method checks and scores the checkboxes that make up question five.
     * When all three checkboxes are checked the right answer get 20 points and the wrong answer get nothing.
     *
     * @param addMadLiberation is if the "Mad Liberation" box is checked or unchecked.
     * @param addGoodWillPrevail is if the "Good Will Prevail" box is checked or unchecked.
     * * @param addDarkSide is if the "Dark Side of the Moon" box is checked or unchecked.
     * @param addRebelEra is if the "Rebel Era" box is checked or unchecked.
     * @param addSayitLoud is if the "Say it Loud" box is checked or unchecked.
     * @return the points that are scored by selecting the correct checkboxes.
     */

    private int calculatecheckBoxPoints(boolean addMadLiberation, boolean addGoodWillPrevail,
                                        boolean addDarkSide, boolean addRebelEra,
                                        boolean addSayitLoud) {
                                         {
        int checkBoxPoints = 0;

        if (addMadLiberation && addGoodWillPrevail && addRebelEra && addSayitLoud && !addDarkSide ) {
            checkBoxPoints += 20;
        }


        if (addDarkSide) {
//            Incorrect answer - Don't count
        }

         else {
//            Incorrect answer - Don't count
        }

        return checkBoxPoints;
                                         }

    }
}



