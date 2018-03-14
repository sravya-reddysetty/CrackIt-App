package com.example.sys1.crack_it;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class TopicActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        b=(Button)findViewById(R.id.b_sub);
        final Spinner mySpinner=(Spinner) findViewById(R.id.b_select);
        mySpinner.setOnItemSelectedListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(TopicActivity.this,Listview.class);
                String t=mySpinner.getSelectedItem().toString();
                i.putExtra("r",t);
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
