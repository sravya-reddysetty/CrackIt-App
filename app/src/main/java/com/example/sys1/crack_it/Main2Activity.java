package com.example.sys1.crack_it;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sub=(Button)findViewById(R.id.Submit);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main2Activity.this,SeniorAdd.class);
                startActivity(i);
            }
        });
    }
}
