package com.example.fit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Training> {

    Context context;
    int resource;
    ArrayList<Training>  trainings;


    public CustomAdapter(Context context,int resource, ArrayList<Training> trainings) {
        super(context, resource, trainings);

        this.context = context;
        this.resource = resource;
        this.trainings = trainings;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);
        TextView textViewWhen = view.findViewById(R.id.whenRowTextView);
        TextView textViewName = view.findViewById(R.id.nameRowTextView);
        TextView textViewHowLong = view.findViewById(R.id.howLongRowTextView);

        Training traing = trainings.get(position);

        textViewWhen.setText(traing.when);
        textViewName.setText(traing.name);
        textViewHowLong.setText(traing.howLong);

        return view;
    }

}
