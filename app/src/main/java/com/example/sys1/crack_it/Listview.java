package com.example.sys1.crack_it;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Listview extends AppCompatActivity {

   /* protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
    }*/
    public static final String EXTRA_COUNTRY = "EXTRA_COUNTRY";
    //a List of type Question for holding list items
    public List<Question> QuestionList;

    //the listview
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //initializing objects
        QuestionList = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);

        //adding some values to our list
        QuestionList.add(new Question("What is an array"));
        QuestionList.add(new Question("how to sort list in O(n)"));
        QuestionList.add(new Question("name 5 dbms commands"));
        QuestionList.add(new Question("explian transactions"));
        QuestionList.add(new Question("implement queue using only stack"));
        QuestionList.add(new Question("write code for spiral array"));
        QuestionList.add(new Question("what is file allocation table"));
        QuestionList.add(new Question("explain context switching"));
        QuestionList.add(new Question("What is TCP congestion"));
        //creating the adapter
        final MyListAdapter adapter = new MyListAdapter(this, R.layout.cust, QuestionList);

        //attaching adapter to the listview
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //here we can write code to go to another activity to display the answer for the selected question

                Intent i=new Intent(Listview.this,Review.class);

                i.putExtra(EXTRA_COUNTRY, (Serializable) adapter.getItem(position));
                startActivity(i);
                //startActivity(i);
            }
        });
    }
}
