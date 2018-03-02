package com.example.sys1.crack_it;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FloatActivity extends AppCompatActivity {
Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);
        bt=(Button)findViewById(R.id.but);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FloatActivity.this,Main2Activity.class);
                startActivity(i);

            }
        });

    }
}
