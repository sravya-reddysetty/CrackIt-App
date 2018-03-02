package com.example.sys1.crack_it;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SeniorAdd extends AppCompatActivity {
    //private FloatingActionButton fab;
    Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_add);
       /* EditText text1= (EditText)findViewById(R.id.editText);
        EditText text2= (EditText)findViewById(R.id.editText2);
        EditText text3= (EditText)findViewById(R.id.editText3);
        EditText text4= (EditText)findViewById(R.id.editText4);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeniorAdd.this,SeniorExtra.class);
                startActivity(intent);
            }
        });*/
        sub=(Button)findViewById(R.id.add);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SeniorAdd.this,SeniorExtra.class);
                startActivity(i);
            }
        });
    }
}
