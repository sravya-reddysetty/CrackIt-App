package com.example.sys1.crack_it;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class TopicActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button b;
    Spinner round;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        b=(Button)findViewById(R.id.b_sub);
        round=(Spinner)findViewById(R.id.round_num);
        final Spinner mySpinner=(Spinner) findViewById(R.id.b_select);
        mySpinner.setOnItemSelectedListener(this);
        round.setOnItemSelectedListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TopicActivity.this,Listview.class);
                String t=mySpinner.getSelectedItem().toString();
                String round=mySpinner.getSelectedItem().toString();
                i.putExtra("r",t);
               // i.putExtra("round",round);

                startActivity(i);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
