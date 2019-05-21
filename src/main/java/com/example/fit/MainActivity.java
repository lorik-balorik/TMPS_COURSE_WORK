package com.example.fit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Paper.init(this);
        Singleton.getInstance(this);

        EditText nameEditText = findViewById(R.id.Name_editText);
        EditText phoneEditText = findViewById(R.id.phone_editText);
        EditText emailEditText = findViewById(R.id.email_editText);
        EditText ageEditText = findViewById(R.id.age_editText);
        EditText heightEditText = findViewById(R.id.height_editText);
        EditText weightEditText = findViewById(R.id.weight_editText);

        Button nextButton = findViewById(R.id.next_button);

        RadioGroup radioGroup = findViewById(R.id.gender_radioGroup);
        RadioButton female = findViewById(R.id.female_RadioButton);

        nextButton.setOnClickListener((View v) -> {

            EditText[] editTexts = Adapter.convertToEditTextArray(nameEditText, phoneEditText, emailEditText, ageEditText, heightEditText, weightEditText);

            if( Mediator.checkEditText( editTexts ) ) {
                System.out.println("_________________YES__________________________________");

                PersonalInfo personalInfo = Adapter.getPersonalInfoWithAllDataFromEditTexts(editTexts);
                personalInfo.setGender(female.isChecked());


                Paper.book().write("personalInfo", personalInfo);

                personalInfo = (PersonalInfo) Paper.book().read("personalInfo");

                //personalInfo.printInConsoleAllData();

                if (true) {
                    Intent intent = new Intent(this, MainMenuActivity.class);
                    startActivity(intent);
                }

            } else {
                System.out.println("_________________NO___________________________________");
            }

        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton female = findViewById(R.id.female_RadioButton);
                RadioButton male = findViewById(R.id.male_RadioButton);

                switch (checkedId) {
                    case R.id.male_RadioButton:
                        female.setChecked(false);
                        break;
                    case R.id.female_RadioButton:
                        male.setChecked(false);
                        break;
                }
            }
        });


    }
}
