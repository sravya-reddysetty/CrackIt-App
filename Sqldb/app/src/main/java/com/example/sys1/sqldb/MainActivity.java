package com.example.sys1.sqldb;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Cursor c=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button)findViewById(R.id.but)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DBHelper mydb=new DBHelper(MainActivity.this);
                try{
                    mydb.createDB();
                }catch (IOException e){
                    throw new Error("unable to open");
                }
                try{
                    mydb.openDatabase();
                }catch (SQLiteException sql){
                    throw sql;
                }
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
                c=mydb.query();
                if(c.moveToFirst()){
                    do{
                        Toast.makeText(MainActivity.this,
                                "_id:"+c.getString(0)+"\n"+
                        "name:"+c.getString(1),Toast.LENGTH_LONG).show();
                    }while (c.moveToNext());
                }
            }

        });





    }
}

