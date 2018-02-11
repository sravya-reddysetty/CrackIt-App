package com.example.sys1.check;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
  SQLiteDatabase sq;
    Button bt4;
    EditText et1, et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sq = openOrCreateDatabase("dhem.db", Context.MODE_PRIVATE, null);//mode private means only u can use it
        sq.execSQL("create table if not exists tent (name TEXT,house TEXT)");
        bt4 = (Button) findViewById(R.id.bt4);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* ContentValues val = new ContentValues();
                val.put("name", et1.getText().toString());//attribute name in the table is used as key
                val.put("house", et2.getText().toString());

                long count = sq.insert("tent", null, val);
                if (count > 0) {
                    Toast.makeText(MainActivity.this, "insertion done", Toast.LENGTH_LONG).show();
                    Intent i= new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "insertion not done", Toast.LENGTH_LONG).show();
                }*/

                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    return;
                }
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:9963703407"));
                startActivity(i);
            }
        });
    }
      /*  b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ContentValues cv=new ContentValues();
                cv.put("name",e1.getText().toString());
                cv.put("age",e1.getText().toString());
                long c=sq.insert("check",null,cv);
                if(c>0)
                {
                    Toast.makeText(MainActivity.this, " success", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();
                }
            }

        });*/


    }

