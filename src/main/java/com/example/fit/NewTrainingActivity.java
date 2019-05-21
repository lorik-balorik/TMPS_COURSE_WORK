package com.example.fit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import io.paperdb.Paper;

public class NewTrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_training);

        Button saveButton = findViewById(R.id.saveNewTraining_Button);
        EditText[] editTexts = new EditText[4];

        editTexts[0] = findViewById(R.id.newName_editText);
        editTexts[1] = findViewById(R.id.newWhen_editText);
        editTexts[2] = findViewById(R.id.newHowLong_editText);
        editTexts[3] = findViewById(R.id.newDescription_editText);


        saveButton.setOnClickListener((View v) -> {

            if(Mediator.checkNewTrainingEditText(editTexts)){

                Training.Builder builder = new Training.Builder();
                builder.setName(editTexts[0].getText().toString());
                builder.setWhen(editTexts[1].getText().toString());
                builder.setHowLong(editTexts[2].getText().toString());
                builder.setText(editTexts[3].getText().toString());

                Training training = builder.getResult();

                Memento.addNewTraining(training);
                finish();
            }

        });
    }
}
