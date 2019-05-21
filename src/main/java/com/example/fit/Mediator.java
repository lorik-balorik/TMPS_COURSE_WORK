package com.example.fit;

import android.widget.EditText;


public class Mediator {

    public static boolean checkEditText(EditText[] editTexts) {
        for (EditText editText : editTexts) {
            if (editText.length() == 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkNewTrainingEditText(EditText[] editTexts){
        for (EditText editText : editTexts) {
            if (editText.length() == 0) {
                return false;
            }
        }

        return true;
    }



}
