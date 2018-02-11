package com.example.sys1.check;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    SQLiteDatabase pq;
    Button pb,nb;
    TextView tv1,tv2,tv3,tv4,tv5;
    private Cursor c;
    private static final String SELECT_SQL = "SELECT * FROM tent";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pq = openOrCreateDatabase("dhem.db", Context.MODE_PRIVATE,null);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        pb=(Button)findViewById(R.id.pb);
        nb=(Button)findViewById(R.id.nb);
        //pb.setOnClickListener(this);
        //nb.setOnClickListener(this);
        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movePrev();
            }
        });
        nb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveNext();
            }
        });
        c = pq.rawQuery(SELECT_SQL, null);
        c.moveToFirst();
        showRecords();
    }
    protected void showRecords() {
        String name = c.getString(0);
        String house = c.getString(1);

        tv1.setText("name:"+name);
        tv2.setText("house no:"+house);

    }
    protected void moveNext() {
        if (!c.isLast())
            c.moveToNext();

        showRecords();
    }

    protected void movePrev() {
        if (!c.isFirst())
            c.moveToPrevious();

        showRecords();

    }
}
