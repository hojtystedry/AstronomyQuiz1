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
     * This method checks the first question.
     */
    public void checkQuestion1(View view) {
        checkCheckboxQuestion(R.id.chb_q1_a1, R.id.chb_q1_a2, R.id.chb_q1_a3, R.id.chb_q1_a4, false, true, true, false);
    }

    /**
     * This method checks the second question.
     */
    public void checkQuestion2(View view) {
        checkRadioButtonQuestion(R.id.rbtn_q2_a1, R.id.rbtn_q2_a2, R.id.rbtn_q2_a3, R.id.rbtn_q2_a4, R.string.q2_false_a1, R.string.q2_false_a2, R.string.q2_false_a3, R.string.q2_correct_a4);
    }

    /**
     * This method check the third question.
     */
    public void checkQuestion3(View view) {
        checkCheckboxQuestion(R.id.chb_q3_a1, R.id.chb_q3_a2, R.id.chb_q3_a3, R.id.chb_q3_a4, false, true, false, true);
    }

    /**
     * This method checks the fourth question.
     */
    public void checkQuestion4(View view) {
        checkEditTextQuestion(R.id.edtxt_q4, "Polaris", R.string.correct_answer, R.string.q4_false_answer);
    }

    /**
     * This method checks the fifth question.
     */
    public void checkQuestion5(View view) {
        checkRadioButtonQuestion(R.id.rbtn_q5_a1, R.id.rbtn_q5_a2, R.id.rbtn_q5_a3, R.id.rbtn_q5_a4, R.string.radio_false, R.string.q5_correct_a2, R.string.q5_false_a3, R.string.radio_false);
    }

    /**
     * This method checks the sixth question.
     */
    public void checkQuestion6(View view) {
        checkRadioButtonQuestion(R.id.rbtn_q6_a1, R.id.rbtn_q6_a2, R.id.rbtn_q6_a3, R.id.rbtn_q6_a4, R.string.q6_false_a1, R.string.q6_false_a2, R.string.q6_false_a3, R.string.q6_correct_a4);
    }

    /**
     * This method checks question 7.
     */
    public void checkQuestion7(View view) {
        checkCheckboxQuestion(R.id.chb_q7_a1, R.id.chb_q7_a2, R.id.chb_q7_a3, R.id.chb_q7_a4, true, false, false, true);
    }

    /**
     * This method checks question 8.
     */
    public void checkQuestion8(View view) {
        checkEditTextQuestion(R.id.edtxt_q8, "Saturn", R.string.correct_answer, R.string.q8_false_answer);
    }

    /**
     * This method checks question 9.
     */
    public void checkQuestion9(View view) {
        checkRadioButtonQuestion(R.id.rbtn_q9_a1, R.id.rbtn_q9_a2, R.id.rbtn_q9_a3, R.id.rbtn_q9_a4, R.string.radio_false, R.string.correct_answer, R.string.radio_false, R.string.radio_false);
    }

    /**
     * This method checks question 10.
     */
    public void checkQuestion10(View view) {
        checkRadioButtonQuestion(R.id.rbtn_q10_a1, R.id.rbtn_q10_a2, R.id.rbtn_q10_a3, R.id.rbtn_q10_a4, R.string.correct_answer, R.string.q10_false_a2, R.string.q10_false_a3, R.string.q10_false_a4);
    }

    /**
     * This method evaluates all questions and shows a toast with overall score.
     */
    public void getScore(View view) {
        // check if all answers are answered

        if (
            //question 1
                !isAnsweredCheckbox(R.id.chb_q1_a1, R.id.chb_q1_a2, R.id.chb_q1_a3, R.id.chb_q1_a4)
                        ||
                        //question 2
                        !isAnsweredRadioButton(R.id.rbtn_q2_a1, R.id.rbtn_q2_a2, R.id.rbtn_q2_a3, R.id.rbtn_q2_a4)
                        ||
                        //question 3
                        !isAnsweredCheckbox(R.id.chb_q3_a2, R.id.chb_q3_a2, R.id.chb_q3_a3, R.id.chb_q3_a4)
                        ||
                        //question 4
                        !isAnsweredEditText(R.id.edtxt_q4)
                        ||
                        //question 5
                        !isAnsweredRadioButton(R.id.rbtn_q5_a1, R.id.rbtn_q5_a2, R.id.rbtn_q5_a3, R.id.rbtn_q5_a4)
                        ||
                        //question 6
                        !isAnsweredRadioButton(R.id.rbtn_q6_a1, R.id.rbtn_q6_a2, R.id.rbtn_q6_a3, R.id.rbtn_q6_a4)
                        ||
                        //question 7
                        !isAnsweredCheckbox(R.id.chb_q7_a1, R.id.chb_q7_a2, R.id.chb_q7_a3, R.id.chb_q7_a4)
                        ||
                        //question 8
                        !isAnsweredEditText(R.id.edtxt_q8)
                        ||
                        //question 9
                        !isAnsweredRadioButton(R.id.rbtn_q9_a1, R.id.rbtn_q9_a2, R.id.rbtn_q9_a3, R.id.rbtn_q9_a4)
                        ||
                        //question 10
                        !isAnsweredRadioButton(R.id.rbtn_q10_a1, R.id.rbtn_q10_a2, R.id.rbtn_q10_a3, R.id.rbtn_q10_a4)
                ) {
            createLongToast(R.string.missing_answer);
            return;
        }

        // create score variable
        int score = 0;

        // evaluate the answers and add 1 to the score variable if the answer is correct

        //question 1
        if (isCorrectCheckbox(R.id.chb_q1_a1, R.id.chb_q1_a2, R.id.chb_q1_a3, R.id.chb_q1_a4, false, true, true, false)) {
            score++;
        }

        //question 2
        if (getRadioButtonState(R.id.rbtn_q2_a4)) {
            score++;
        }

        //question 3
        if (isCorrectCheckbox(R.id.chb_q3_a1, R.id.chb_q3_a2, R.id.chb_q3_a3, R.id.chb_q3_a4, false, true, false, true)) {
            score++;
        }

        //question 4
        if (isCorrectEditText(R.id.edtxt_q4, "Polaris")) {
            score++;
        }

        //question 5
        if (getRadioButtonState(R.id.rbtn_q5_a2)) {
            score++;
        }

        //question 6
        if (getRadioButtonState(R.id.rbtn_q6_a4)) {
            score++;
        }

        //question 7
        if (isCorrectCheckbox(R.id.chb_q7_a1, R.id.chb_q7_a2, R.id.chb_q7_a3, R.id.chb_q7_a4, true, false, false, true)) {
            score++;
        }

        //question 8
        if (isCorrectEditText(R.id.edtxt_q8, "Saturn")) {
            score++;
        }

        //question 9
        if (getRadioButtonState(R.id.rbtn_q9_a2)) {
            score++;
        }

        //question 10
        if (getRadioButtonState(R.id.rbtn_q10_a1)) {
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
     * @return boolean true if the question is answered, false in case the answer is missing.
     */
    private boolean isAnsweredCheckbox(int checkboxId1, int checkboxId2, int checkboxId3, int checkboxId4) {
        if (!getCheckboxState(checkboxId1) && !getCheckboxState(checkboxId2) && !getCheckboxState(checkboxId3) && !getCheckboxState(checkboxId4)) {
            return false;
        } else {
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
     * @return boolean true if the question is answered, false in case the answer is missing.
     */
    private boolean isAnsweredRadioButton(int radioButtonId1, int radioButtonId2, int radioButtonId3, int radioButtonId4) {
        if (!getRadioButtonState(radioButtonId1) && !getRadioButtonState(radioButtonId2) && !getRadioButtonState(radioButtonId3) && !getRadioButtonState(radioButtonId4)) {
            return false;
        } else {
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
        String userAnswer = currentEditText.getText().toString().trim();

        // compare with empty string
        String emptyString = "";

        if (userAnswer.equals(emptyString)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method checks checkbox (multiple choice) questions and displays toast message about the answer. It takes 8 parameters - four integers giving the checkbox ids and four booleans
     * for the correct values of the checkboxes.
     *
     * @param id1     - id of the first checkbox in the question
     * @param id2     - id of the second checkbox in the question
     * @param id3     - id of the third checkbox in the question
     * @param id4     - id of the fourth checkbox in the question
     * @param answer1 - correct value of checkbox id1
     * @param answer2 - correct value of checkbox id2
     * @param answer3 - correct value of checkbox id3
     * @param answer4 - correct value of checkbox id4
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
     * @param id1     - id of the first checkbox in the question
     * @param id2     - id of the second checkbox in the question
     * @param id3     - id of the third checkbox in the question
     * @param id4     - id of the fourth checkbox in the question
     * @param answer1 - correct value of checkbox id1
     * @param answer2 - correct value of checkbox id2
     * @param answer3 - correct value of checkbox id3
     * @param answer4 - correct value of checkbox id4
     * @return true if answer is correct, false otherwise
     */
    private boolean isCorrectCheckbox(int id1, int id2, int id3, int id4, boolean answer1, boolean answer2, boolean answer3, boolean answer4) {

        // compare state of the checkbox with the correct state. If all four fit display message for correct answer
        if ((getCheckboxState(id1) == answer1) && (getCheckboxState(id2) == answer2) && (getCheckboxState(id3) == answer3) && (getCheckboxState(id4) == answer4)) {
            return true;

        // otherwise display message for false answer
        } else {
            return false;
        }
    }


    /**
     * This method checks radiobutton / one choice questions and displays appropriate toast message. It takes 8 parameters - four integers giving the ids of radio buttons
     * and four integers giving the ids of desired toast messages for each id.
     *
     * @param buttonId1 - id of the first radio button in the question
     * @param buttonId2 - id of the second radio button in the question
     * @param buttonId3 - id of the third radio button in the question
     * @param buttonId4 - id of the fourth radio button in the question
     * @param stringId1 - message to be displayed in toast if buttonId1 is chosen
     * @param stringId2 - message to be displayed in toast if buttonId2 is chosen
     * @param stringId3 - message to be displayed in toast if buttonId3 is chosen
     * @param stringId4 - message to be displayed in toast if buttonId4 is chosen
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
     * This method checks edit text questions and prints appropriate message to toast. It gets the text from the field, compares it to correct answer.
     *
     * @param editTextId     id of the edit text field
     * @param answer         correct answer in form of String
     * @param toastCorrectId id of toast message to be displayed in case answer is correct
     * @param toastFalseId   id of toast message to be displayed in case answer is false
     */

    private void checkEditTextQuestion(int editTextId, String answer, int toastCorrectId, int toastFalseId) {

        // compare to the correct answer and display corresponding toast message
        if (isCorrectEditText(editTextId, answer)) {
            createShortToast(toastCorrectId);
        } else {
            createShortToast(toastFalseId);
        }
    }

    /**
     * This method evaluates edit text questions and returns a boolean. It gets the text from the field and compares it to correct answer.
     *
     * @param editTextId id of the edit text field
     * @param answer     correct answer in form of String
     * @return true if entered text is the same as correct answer
     */

    private boolean isCorrectEditText(int editTextId, String answer) {

        // get text from edit text and save as string
        EditText currentEditText = (EditText) findViewById(editTextId);
        String userAnswer = currentEditText.getText().toString().trim();

        // compare to the correct answer
        if (userAnswer.equals(answer)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method finds a checkbox and stores it's state in a boolean.
     *
     * @param checkboxId id of the checkbox in activity_main.xml
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
     * @return boolean true/false according to the state of the radio button
     */
    private boolean getRadioButtonState(int radioButtonId) {
        RadioButton currentRadioButton = (RadioButton) findViewById(radioButtonId);
        return currentRadioButton.isChecked();
    }

    /**
     * This method creates toast message of length SHORT given string.
     *
     * @param messageId id of the string corresponding to the desired message
     */
    private void createShortToast(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
    }

    /**
     * This method creates toast message of length LONG given string.
     *
     * @param messageId id of the string corresponding to the desired message
     */
    private void createLongToast(int messageId) {
        Toast.makeText(this, messageId, Toast.LENGTH_LONG).show();
    }

}
