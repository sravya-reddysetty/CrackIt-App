package com.example.sys1.prescriptor;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class doctor_preview extends AppCompatActivity {
    SQLiteDatabase sq;
    Button pre,next;
    TextView name,loc,phone,d1,d2,dl1,dl2,dp1,dp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_preview);



       /* sq=openOrCreateDatabase("medicine.db", Context.MODE_PRIVATE,null);
        sq.execSQL("Create table if not exists doctors (name TEXT,loc TEXT,phone TEXT,field TEXT");
        ContentValues val = new ContentValues();
        val.put("name","anvesh");//attribute name in the table is used as key
        val.put("loc","hyderabasd");
        val.put("phone","87959873");
        val.put("field","c");
        sq.insert("doctors",null,val);*/



    }
}
