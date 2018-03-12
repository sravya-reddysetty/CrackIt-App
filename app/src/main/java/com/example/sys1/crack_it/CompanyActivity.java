package com.example.sys1.crack_it;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

public class CompanyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        b=(Button)findViewById(R.id.b_sub);
        final Spinner mySpinner=(Spinner) findViewById(R.id.b_select);
        mySpinner.setOnItemSelectedListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CompanyActivity.this,Listview.class);
                String t=mySpinner.getSelectedItem().toString();
              //  Toast.makeText(getApplicationContext(),t,Toast.LENGTH_SHORT).show();
                i.putExtra("company",t);
                startActivity(i);
            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
