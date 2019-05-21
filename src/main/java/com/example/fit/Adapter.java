package com.example.fit;

import android.widget.EditText;

public class Adapter {

    public static EditText[] convertToEditTextArray(EditText name, EditText phone, EditText email, EditText age, EditText height, EditText weight) {
        EditText[] editTexts = new EditText[6];

        editTexts[0] = name;
        editTexts[1] = phone;
        editTexts[2] = email;
        editTexts[3] = age;
        editTexts[4] = height;
        editTexts[5] = weight;

        return editTexts;
    }

    public static PersonalInfo getPersonalInfoWithAllDataFromEditTexts(EditText[] editTexts) {

        int i=0;

        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setName( editTexts[0].getText().toString() );
        personalInfo.setPhone( editTexts[1].getText().toString() );
        personalInfo.setEmail( editTexts[2].getText().toString() );
        personalInfo.setAge( Integer.parseInt(editTexts[3].getText().toString()) );
        personalInfo.setHeight( Integer.parseInt(editTexts[4].getText().toString()) );
        personalInfo.setWeight( Integer.parseInt(editTexts[5].getText().toString()) );

        return personalInfo;
    }

    public static String[] getStringArrayFromPersonalInfo(PersonalInfo personalInfo) {

        String[] strings = new String[7];
        strings[0] = personalInfo.name;
        strings[1] = personalInfo.email;

        if(personalInfo.gender == true){
            strings[2]="Female";
        }
        else {
            strings[2]="Male";
        }

        strings[3] = String.valueOf(personalInfo.age);
        strings[4] = String.valueOf(personalInfo.phone);
        strings[5] = String.valueOf(personalInfo.weight);
        strings[6] = String.valueOf(personalInfo.height);

        return strings;
    }

}
