package com.example.fit;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import io.paperdb.Paper;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ListView listView =  findViewById(R.id.listView);
        Button profileButton = findViewById(R.id.profileButton);
        Button settingsButton = findViewById(R.id.settingsButton);
        Button newButton = findViewById(R.id.newButton);

        settingsButton.setOnClickListener((View v) -> {

            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        });

        newButton.setOnClickListener((View v) -> {

            Intent intent = new Intent(this, NewTrainingActivity.class);
            startActivity(intent);
        });

        Intent intentCheckout = new Intent(this, CheckOutActivity.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long l) {
                //Object clickItemObj = adapterView.getAdapter().getItem(index);
                Training training = (Training) adapterView.getAdapter().getItem(index);;
                //Toast.makeText(MainMenuActivity.this, "You clicked " + training.name, Toast.LENGTH_SHORT).show();

                intentCheckout.putExtra("trainingFromList", training);
                startActivity(intentCheckout);
            }
        });

        profileButton.setOnClickListener((View v) -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        });

        ArrayList<Training> trainings = new ArrayList<>();
//        trainings.add(new Training("Gym", "12:30", "1:00", "Do your best"));
//        trainings.add(new Training("Gym2", "12:30", "1:00", "Do your best"));
//        trainings.add(new Training("Gym32", "12:30", "1:00", "Do your best"));
//        trainings.add(new Training("Gym4", "12:30", "1:00", "Do your best"));

        if(Paper.book().read("trainingArray") != null)
            trainings = (ArrayList<Training>) Paper.book().read("trainingArray");

        PersonalInfo personalInfo = (PersonalInfo) Paper.book().read("personalInfo");

        ArrayAdapter<Training> adapter = new CustomAdapter(this, R.layout.row, trainings);
        listView.setAdapter(adapter);

        profileButton.setText(personalInfo.name);
        personalInfo.printInConsoleAllData();


    }

    @Override
    public void onResume(){
        super.onResume();

        ListView listView =  findViewById(R.id.listView);

        ArrayList<Training> trainings = new ArrayList<>();

        if(Paper.book().read("trainingArray") != null)
            trainings = (ArrayList<Training>) Paper.book().read("trainingArray");

        PersonalInfo personalInfo = (PersonalInfo) Paper.book().read("personalInfo");

        ArrayAdapter<Training> adapter = new CustomAdapter(this, R.layout.row, trainings);
        listView.setAdapter(adapter);


    }

}
