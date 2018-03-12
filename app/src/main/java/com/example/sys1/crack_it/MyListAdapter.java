package com.example.sys1.crack_it;

/**
 * Created by yoshita on 2/24/2018.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
public class MyListAdapter extends ArrayAdapter<Question> {

    //the list values in the List of type Question

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public MyListAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, parent, false);

        //getting the view elements of the list from the view
        TextView textViewName = view.findViewById(R.id.textViewName);


        //getting the Question of the specified position
        Question Question =getItem(position);

        //adding values to the list item

        textViewName.setText(Question.getName());

        //finally returning the view
        return view;
    }
}


