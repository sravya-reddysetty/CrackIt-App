package com.example.sys1.gridviewreal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView gv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv=(GridView)findViewById(R.id.gv);
        String[] br={"CSE","ECE","EEE","CIV","MECH"};
        ArrayAdapter ad=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,br);
        gv.setAdapter(ad);
    }
}
