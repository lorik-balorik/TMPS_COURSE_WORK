package com.example.fit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import io.paperdb.Paper;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView name = findViewById(R.id.nameProfileTextView);
        TextView email = findViewById(R.id.emailProfileTextView);
        TextView gender = findViewById(R.id.genderProfileTextView);
        TextView age = findViewById(R.id.ageProfileTextView);
        TextView phone = findViewById(R.id.phoneProfileTextView);
        TextView weight = findViewById(R.id.weightProfileTextView);
        TextView height = findViewById(R.id.heightProfileTextView);

        PersonalInfo personalInfo = (PersonalInfo) Paper.book().read("personalInfo");
        String[] strings = Adapter.getStringArrayFromPersonalInfo(personalInfo);

        name.setText(strings[0]);
        email.setText(strings[1]);
        gender.setText(strings[2]);
        age.setText(strings[3]);
        phone.setText(strings[4]);
        weight.setText(strings[5]);
        height.setText(strings[6]);
    }
}
