package com.example.sys1.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
     ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        String[] Branch={"CSE","ECE","EEE","MECH","CIV"};
        ArrayAdapter ad=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,Branch);
        lv.setAdapter(ad);

    }
}
