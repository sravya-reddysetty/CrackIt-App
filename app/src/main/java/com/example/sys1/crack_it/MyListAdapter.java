package com.example.sys1.crack_it;

/**
 * Created by sys1 on 2/24/2018.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
public class MyListAdapter extends ArrayAdapter<Question> {

    //the list values in the List of type Question

    List<Question> QuestionList;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public MyListAdapter(Context context, int resource, List<Question> QuestionList) {
        super(context, resource, QuestionList);
        this.context = context;
        this.resource = resource;
        this.QuestionList = QuestionList;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        TextView textViewName = view.findViewById(R.id.textViewName);


        //getting the Question of the specified position
        Question Question = QuestionList.get(position);

        //adding values to the list item

        textViewName.setText(Question.getName());

        //finally returning the view
        return view;
    }
}


