package com.example.sys1.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            @Override

    sp=(Spinner)findViewById(R.id.sp);
    String[] br={"select","cse","ece","civ","mech","eee"};
    ArrayAdapter ad=new ArrayAdapter(MainActivity.this,android.R.layout.simple_dropdown_item_1line,br);
    sp.setAdapter(ad);
    sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //case 0 is not selected so not defined
            switch(position){

                case 1:
                    Toast.makeText(MainActivity.this,"CSE", Toast.LENGTH_LONG).show();
                case 2:
                    Toast.makeText(MainActivity.this,"CSE", Toast.LENGTH_LONG).show();
                case 3:
                    Toast.makeText(MainActivity.this,"CSE", Toast.LENGTH_LONG).show();
                case 4:
                    Toast.makeText(MainActivity.this,"CSE", Toast.LENGTH_LONG).show();
            }

        }

    }
});public void onNothingSelected(AdapterView<?> parent) {

        }
        }
