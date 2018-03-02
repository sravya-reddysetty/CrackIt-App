package com.example.sys1.crack_it;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Review extends AppCompatActivity {
    TextView textView;
    public List<Question> QuestionList;
    public ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Question ques = (Question) getIntent().getSerializableExtra(Listview.EXTRA_COUNTRY);
        textView = (TextView) findViewById(R.id.tt);
        textView.setText(ques.getName());
       /* QuestionList = new ArrayList<>();
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
        listView.setAdapter(adapter);*/
    }
}
