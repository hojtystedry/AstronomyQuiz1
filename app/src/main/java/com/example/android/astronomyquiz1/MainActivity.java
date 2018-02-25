package com.example.android.astronomyquiz1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method evaluates the first question.
     */

    public void evaluateQuestion1(View view) {

        checkCheckboxQuestion(R.id.q1_a1, R.id.q1_a2, R.id.q1_a3, R.id.q1_a4, false, true, true, false);

    }

    /**
     * This method evaluates the second question.
     */

    public void evaluateQuestion2(View view) {

        checkRadioButtonQuestion(R.id.q2_a1_radiobutton, R.id.q2_a2_radiobutton, R.id.q2_a3_radiobutton, R.id.q2_a4_radiobutton, R.string.q2_false_a1, R.string.q2_false_a2, R.string.q2_false_a3, R.string.q2_correct_a4);

    }

    /**
     * This method evaluates the third question.
     */

    public void evaluateQuestion3(View view) {

        checkCheckboxQuestion(R.id.q3_a1, R.id.q3_a2, R.id.q3_a3, R.id.q3_a4, false, true, false, true);

    }

    /**
     * This method evaluates the fourth question.
     */

    public void evaluateQuestion4(View view) {
        checkEditTextQuestion(R.id.q4_edittext, "Polaris", R.string.correct_answer, R.string.q4_false_answer);
    }

    /**
     * This method evaluates the fifth question.
     */

    public void evaluateQuestion5(View view) {
        checkRadioButtonQuestion(R.id.q5_a1_radiobutton, R.id.q5_a2_radiobutton, R.id.q5_a3_radiobutton, R.id.q5_a4_radiobutton, R.string.radio_false, R.string.q5_correct_a2, R.string.q5_false_a3, R.string.radio_false);
    }

    /**
     * This method evaluates the sixth question.
     */

    public void evaluateQuestion6(View view) {
        checkRadioButtonQuestion(R.id.q6_a1_radiobutton, R.id.q6_a2_radiobutton, R.id.q6_a3_radiobutton, R.id.q6_a4_radiobutton, R.string.q6_false_a1, R.string.q6_false_a2, R.string.q6_false_a3, R.string.q6_correct_a4);
    }

    /**
     * This method evaluates question 7.
     */

    public void evaluateQuestion7(View view) {
        checkCheckboxQuestion(R.id.q7_a1, R.id.q7_a2, R.id.q7_a3, R.id.q7_a4, true, false, false, true);
    }

    /**
     * This method evaluates question 8.
     */

    public void evaluateQuestion8(View view) {
        checkEditTextQuestion(R.id.q8_edittext, "Saturn", R.string.correct_answer, R.string.q8_false_answer);
    }

    /**
     * This method evaluates question 9.
     */

    public void evaluateQuestion9(View view) {
        checkRadioButtonQuestion(R.id.q9_a1_radiobutton, R.id.q9_a2_radiobutton, R.id.q9_a3_radiobutton, R.id.q9_a4_radiobutton, R.string.radio_false, R.string.correct_answer, R.string.radio_false, R.string.radio_false);
    }

    /**
     * This method evaluates question 10.
     */

    public void evaluateQuestion10(View view) {
        checkRadioButtonQuestion(R.id.q10_a1_radiobutton, R.id.q10_a2_radiobutton, R.id.q10_a3_radiobutton, R.id.q10_a4_radiobutton, R.string.correct_answer, R.string.q10_false_a2, R.string.q10_false_a3, R.string.q10_false_a4);
    }

    /**
     * This method checks all questions and shows a toast with overall score.
     */

    public void getScore(View view) {
        // check if all answers are answered

        if (
                //question 1
                !isAnsweredCheckbox(R.id.q1_a1, R.id.q1_a2, R.id.q1_a3, R.id.q1_a4)
                ||
                //question 2
                !isAnsweredRadioButton(R.id.q2_a1_radiobutton, R.id.q2_a2_radiobutton, R.id.q2_a3_radiobutton, R.id.q2_a4_radiobutton)
                ||
                //question 3
                !isAnsweredCheckbox(R.id.q3_a2, R.id.q3_a2, R.id.q3_a3, R.id.q3_a4)
                ||
                //question 4
                !isAnsweredEditText(R.id.q4_edittext)
                ||
                //question 5
                !isAnsweredRadioButton(R.id.q5_a1_radiobutton, R.id.q5_a2_radiobutton, R.id.q5_a3_radiobutton, R.id.q5_a4_radiobutton)
                ||
                //question 6
                !isAnsweredRadioButton(R.id.q6_a1_radiobutton, R.id.q6_a2_radiobutton, R.id.q6_a3_radiobutton, R.id.q6_a4_radiobutton)
                ||
                //question 7
                !isAnsweredCheckbox(R.id.q7_a1, R.id.q7_a2, R.id.q7_a3, R.id.q7_a4)
                ||
                //question 8
                !isAnsweredEditText(R.id.q8_edittext)
                ||
                //question 9
                !isAnsweredRadioButton(R.id.q9_a1_radiobutton, R.id.q9_a2_radiobutton, R.id.q9_a3_radiobutton, R.id.q9_a4_radiobutton)
                ||
                //question 10
                !isAnsweredRadioButton(R.id.q10_a1_radiobutton, R.id.q10_a2_radiobutton, R.id.q10_a3_radiobutton, R.id.q10_a4_radiobutton)
                ) {
            createShortToast(R.string.missing_answer);
            return;
        }

        // create score variable
        int score = 0;

        // evaluate the answers and add 1 to the score variable if the answer is correct

        //question 1
        if (isCorrectCheckbox(R.id.q1_a1, R.id.q1_a2, R.id.q1_a3, R.id.q1_a4, false, true, true, false)) {
            score++;
        }

        //question 2
        if (getRadioButtonState(R.id.q2_a4_radiobutton)) {
            score++;
        }

        //question 3
        if (isCorrectCheckbox(R.id.q3_a1, R.id.q3_a2, R.id.q3_a3, R.id.q3_a4, false, true, false, true)) {
            score++;
        }

        //question 4
        if (isCorrectEditText(R.id.q4_edittext, "Polaris")){
            score++;
        }

        //question 5
        if (getRadioButtonState(R.id.q5_a2_radiobutton)) {
            score++;
        }

        //question 6
        if (getRadioButtonState(R.id.q6_a4_radiobutton)) {
            score++;
        }

        //question 7
        if (isCorrectCheckbox(R.id.q7_a1, R.id.q7_a2, R.id.q7_a3, R.id.q7_a4, true, false, false, true)) {
            score++;
        }

        //question 8
        if (isCorrectEditText(R.id.q8_edittext, "Saturn")) {
            score++;
        }

        //question 9
        if (getRadioButtonState(R.id.q9_a2_radiobutton)) {
            score++;
        }

        //question 10
        if (getRadioButtonState(R.id.q10_a1_radiobutton)) {
            score++;
        }


        String displayScore = "Your score is " + score + " out of 10.";

        Toast.makeText(this, displayScore, Toast.LENGTH_LONG).show();


    }

    /**
     * This method checks whether a checkbox question is answered or not.
     *
     * @param checkboxId1 - first checkbox id
     * @param checkboxId2 - second checkbox id
     * @param checkboxId3 - third checkbox id
     * @param checkboxId4 - fourth checkbox id
     *
     * @return boolean true if the question is answered, false in case the answer is missing.
     */

    private boolean isAnsweredCheckbox(int checkboxId1, int checkboxId2, int checkboxId3, int checkboxId4) {
        if (!getCheckboxState(checkboxId1) && !getCheckboxState(checkboxId2) && !getCheckboxState(checkboxId3) && !getCheckboxState(checkboxId4)) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * This method checks whether a radio button question is answered or not.
     *
     * @param radioButtonId1 - first radio button id
     * @param radioButtonId2 - second radio button id
     * @param radioButtonId3 - third radio button id
     * @param radioButtonId4 - fourth radio button id
     *
     * @return boolean true if the question is answered, false in case the answer is missing.
     */

    private boolean isAnsweredRadioButton(int radioButtonId1, int radioButtonId2, int radioButtonId3, int radioButtonId4) {
        if (!getRadioButtonState(radioButtonId1) && !getRadioButtonState(radioButtonId2) && !getRadioButtonState(radioButtonId3) && !getRadioButtonState(radioButtonId4)) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * This method checks whether an edit text question is answered or not.
     *
     * @param editTextId - id of the edit text field
     * @return boolean true if there is some text in the field, false if there is not
     */

    private boolean isAnsweredEditText(int editTextId) {

        // get text from edit text and save as string
        EditText currentEditText = (EditText) findViewById(editTextId);
        String userAnswer = currentEditText.getText().toString();

        // compare with empty string
        String emptyString = "";

        if (userAnswer.equals(emptyString)) {
            return false;
        }
        else {
            return true;
        }
    }


    /**
     * This method evaluates checkbox (multiple choice) questions and displays toast message about the answer. It takes 8 parameters - four integers giving the checkbox ids and four booleans
     * for the correct values of the checkboxes.
     * @param id1 - id of the first checkbox in the question
     * @param id2 - id of the second checkbox in the question
     * @param id3 - id of the third checkbox in the question
     * @param id4 - id of the fourth checkbox in the question
     * @param answer1 - correct value of checkbox id1
     * @param answer2 - correct value of checkbox id2
     * @param answer3 - correct value of checkbox id3
     * @param answer4 - correct value of checkbox id4
     *
     */

    private void checkCheckboxQuestion(int id1, int id2, int id3, int id4, boolean answer1, boolean answer2, boolean answer3, boolean answer4) {

        // Expression compares checkbox state with correct answer given in the parameters. If it fits the toast message for correct answer is displayed.

        if (isCorrectCheckbox(id1, id2, id3, id4, answer1, answer2, answer3, answer4)) {
            createShortToast(R.string.correct_answer);
        }

        // Otherwise the toast message for wrong answer is displayed.
        else {
            createShortToast(R.string.multiple_false_answer);
        }

    }

    /**
     * This method evaluates checkbox (multiple choice) questions and returns a boolean. It takes 8 parameters - four integers giving the checkbox ids and four booleans
     * for the correct values of the checkboxes.
     *
     * @param id1 - id of the first checkbox in the question
     * @param id2 - id of the second checkbox in the question
     * @param id3 - id of the third checkbox in the question
     * @param id4 - id of the fourth checkbox in the question
     * @param answer1 - correct value of checkbox id1
     * @param answer2 - correct value of checkbox id2
     * @param answer3 - correct value of checkbox id3
     * @param answer4 - correct value of checkbox id4
     *
     *@return true if answer is correct, false otherwise
     */

    private boolean isCorrectCheckbox(int id1, int id2, int id3, int id4, boolean answer1, boolean answer2, boolean answer3, boolean answer4) {


        if ((getCheckboxState(id1) == answer1) && (getCheckboxState(id2) == answer2) && (getCheckboxState(id3) == answer3) && (getCheckboxState(id4) == answer4)) {
            return true;
        }

        else {
            return false;
        }

    }


    /**
     *  This method evaluates radiobutton / one choice questions and displays appropriate toast message. It takes 8 parameters - four integers giving the ids of radio buttons
     *  and four integers giving the ids of desired toast messages for each id.
     *
     *  @param buttonId1 - id of the first radio button in the question
     *  @param buttonId2 - id of the second radio button in the question
     *  @param buttonId3 - id of the third radio button in the question
     *  @param buttonId4 - id of the fourth radio button in the question
     *  @param stringId1 - message to be displayed in toast if buttonId1 is chosen
     *  @param stringId2 - message to be displayed in toast if buttonId2 is chosen
     *  @param stringId3 - message to be displayed in toast if buttonId3 is chosen
     *  @param stringId4 - message to be displayed in toast if buttonId4 is chosen
     */

    private void checkRadioButtonQuestion(int buttonId1, int buttonId2, int buttonId3, int buttonId4, int stringId1, int stringId2, int stringId3, int stringId4) {

        if (getRadioButtonState(buttonId1)) {
            createShortToast(stringId1);
        }

        if (getRadioButtonState(buttonId2)) {
            createShortToast(stringId2);
        }

        if (getRadioButtonState(buttonId3)) {
            createShortToast(stringId3);
        }

        if (getRadioButtonState(buttonId4)) {
            createShortToast(stringId4);
        }
    }



    /**
     * This method evaluates edit text questions and prints appropriate message to toast. It gets the text from the field, compares it to correct answer.
     *
     * @param editTextId id of the edit text field
     * @param answer correct answer in form of String
     * @param toastCorrectId id of toast message to be displayed in case answer is correct
     * @param toastFalseId id of toast message to be displayed in case answer is false
     */

    private void checkEditTextQuestion(int editTextId, String answer, int toastCorrectId, int toastFalseId) {

        // compare to the correct answer and display corresponding toast message
        if (isCorrectEditText(editTextId, answer)) {
            createShortToast(toastCorrectId);
        }
        else {
            createShortToast(toastFalseId);
        }
    }

    /**
     * This method evaluates edit text questions and returns a boolean. It gets the text from the field and compares it to correct answer.
     *
     * @param editTextId id of the edit text field
     * @param answer correct answer in form of String
     *
     * @return true if entered text is the same as correct answer
     */

    private boolean isCorrectEditText (int editTextId, String answer) {

        // get text from edit text and save as string
        EditText currentEditText = (EditText) findViewById(editTextId);
        String userAnswer = currentEditText.getText().toString();

        // compare to the correct answer
        if (userAnswer.equals(answer)) {
            return true;
        }
        else {
            return false;
        }
    }



    /**
     * This method finds a checkbox and stores it's state in a boolean.
     *
     * @param checkboxId id of the checkbox in activity_main.xml
     *
     * @return boolean true/false according to the state of the checkbox
     */

    private boolean getCheckboxState(int checkboxId) {
        CheckBox currentCheckBox = (CheckBox) findViewById(checkboxId);
        return currentCheckBox.isChecked();
    }

    /**
     * This method finds a radio button and stores it's state in a boolean.
     *
     * @param radioButtonId id of the radio button in activity_main.xml
     *
     * @return boolean true/false according to the state of the radio button
     */

    private boolean getRadioButtonState(int radioButtonId) {
        RadioButton currentRadioButton = (RadioButton) findViewById(radioButtonId);
        return currentRadioButton.isChecked();
    }


    /**
     *  This method creates toast message of length SHORT given string.
     *
     *  @param messageId id of the string corresponding to the desired message
     */

    private void createShortToast(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

}
