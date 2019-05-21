package com.example.fit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.paperdb.Paper;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button dropButton = findViewById(R.id.dropListButton);

        dropButton.setOnClickListener((View v) -> {
            Paper.book().delete("trainingArray");
        });
    }


}
