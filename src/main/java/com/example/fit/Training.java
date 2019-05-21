package com.example.fit;

import java.io.Serializable;
import java.util.UUID;

public class Training implements Serializable {
    String uniqueID;
    String name;
    String when;
    String howLong;
    String text;

    public Training() {}

    public Training(String nameIn, String whenIn, String howLongIn, String textIn) {
        uniqueID = UUID.randomUUID().toString();
        name = nameIn;
        when = whenIn;
        howLong = howLongIn;
        text = textIn;
    }

    public static Training getCopy(Training trainingIn) {
        return new Training(trainingIn.name, trainingIn.when, trainingIn.howLong, trainingIn.text );
    }

    public static class Builder {

        String nameB, whenB, howLongB, textB;

        public Builder(){}

        public void setName(String nameIn) {
            nameB = nameIn;
        }

        public void setWhen(String whenIn) {
            whenB = whenIn;
        }

        public void setHowLong(String howLongIn) {
            howLongB = howLongIn;
        }

        public void setText(String textIn) {
            textB = textIn;
        }

        public Training getResult(){
            return new Training(nameB, whenB, howLongB, textB);
        }
    }
}
