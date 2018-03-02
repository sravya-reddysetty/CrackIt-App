package com.example.sys1.crack_it;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SeniorExtra extends AppCompatActivity {
  //  private FloatingActionButton fab1;
   Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_extra);
       /* EditText text1= (EditText)findViewById(R.id.editText5);
        EditText text2= (EditText)findViewById(R.id.editText6);
        EditText text3= (EditText)findViewById(R.id.editText7);
        EditText text4= (EditText)findViewById(R.id.editText8);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab1 = (FloatingActionButton) findViewById(R.id.fab);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeniorExtra.this, SeniorAdd.class);
                startActivity(intent);
            }
        });*/
        sub=(Button)findViewById(R.id.add2);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SeniorExtra.this,SeniorAdd.class);
                startActivity(i);
            }
        });
    }
}
