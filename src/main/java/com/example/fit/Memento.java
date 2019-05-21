package com.example.fit;

import java.util.ArrayList;

import io.paperdb.Paper;

public class Memento {

    public static void addNewTraining(Training training) {
        ArrayList<Training> trainings = new ArrayList<>();

        if(Paper.book().read("trainingArray") != null)
            trainings = (ArrayList<Training>) Paper.book().read("trainingArray");

        trainings.add(training);
        Paper.book().write("trainingArray", trainings);
    }

    public static void addCopyOfTraining(Training training) {
        Training copyOfTraining = Training.getCopy(training);

        ArrayList<Training> trainings = new ArrayList<>();

        if(Paper.book().read("trainingArray") != null)
            trainings = (ArrayList<Training>) Paper.book().read("trainingArray");

        trainings.add(copyOfTraining);
        Paper.book().write("trainingArray", trainings);
    }
}


