package com.example.fit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import io.paperdb.Paper;

public class CheckOutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        Training training = (Training) getIntent().getSerializableExtra("trainingFromList");

        TextView nameTextView = findViewById(R.id.checkNameTextView);
        TextView whenTextView = findViewById(R.id.checkWhenTextView);
        TextView howLongTextView = findViewById(R.id.checkHowLongTextView);
        TextView textTextView = findViewById(R.id.checkTextTextView);

        Button copyButton = findViewById(R.id.prototypeButton);

        copyButton.setOnClickListener((View v) -> {
            Memento.addCopyOfTraining(training);
            finish();
        });


        nameTextView.setText(training.name);
        whenTextView.setText(training.when);
        howLongTextView.setText(training.howLong);
        textTextView.setText(training.text);

    }
}
