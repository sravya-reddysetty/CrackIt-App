package com.example.sys1.crack_it;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Spinner mySpinner=(Spinner) findViewById(R.id.branches);
        final Spinner comp=(Spinner)findViewById(R.id.company_name);
        mySpinner.setOnItemSelectedListener(this);
        comp.setOnItemSelectedListener(this);

       // Toast.makeText(getApplicationContext(),mySpinner.getSelectedItem().toString(),Toast.LENGTH_LONG).show();

        final String text = mySpinner.getSelectedItem().toString();
        sub=(Button)findViewById(R.id.Submit);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
                Intent i=new Intent(Main2Activity.this,SeniorAdd.class);
                i.putExtra("Value",mySpinner.getSelectedItem().toString());
                i.putExtra("Val",comp.getSelectedItem().toString());

                startActivity(i);
            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
