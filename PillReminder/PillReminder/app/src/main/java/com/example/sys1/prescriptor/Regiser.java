package com.example.sys1.prescriptor;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regiser extends AppCompatActivity {
    //Button register;
   // DatabaseHelper mydb;
   // EditText username, password, email;
    SQLiteDatabase sq;
    Button bt;
    EditText et1, et2, et3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiser);
        sq = openOrCreateDatabase("medicine.db", Context.MODE_PRIVATE, null);//mode private means only u can use it
        sq.execSQL("create table if not exists users (" +
                " username TEXT NOT NULL,email TEXT NOT NULL ,password TEXT NOT NULL)");
        bt = (Button) findViewById(R.id.Register);
        et1 = (EditText) findViewById(R.id.Username_r);
        et2 = (EditText) findViewById(R.id.Email_r);
        et3 = (EditText) findViewById(R.id.Password_r);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().length()==0||et1.getText().toString().length()==0||et1.getText().toString().length()==0){
                    Toast.makeText(Regiser.this, "Please fill the empty fields", Toast.LENGTH_LONG).show();
                    return;
                }
                ContentValues val = new ContentValues();
                val.put("username", et1.getText().toString());//attribute name in the table is used as key
                val.put("email", et2.getText().toString());
                val.put("password", et3.getText().toString());
                long count = sq.insert("users", null, val);
                if (count > 0) {
                    Toast.makeText(Regiser.this, "Successful registration", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Regiser.this, "Unsuccessful..Try Again ", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(Regiser.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(Regiser.this);
        builder.setMessage("Want to EXIT ?");
        builder.setCancelable(true);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // dialog.cancel();
                finish();

            }
        });
        builder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // finish();
                dialog.cancel();

            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }


}
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiser);
        mydb=new DatabaseHelper(this);
        register=(Button)findViewById(R.id.Register);
        username=(EditText)findViewById(R.id.Username_r);
        password=(EditText)findViewById(R.id.Password_r);
        email=(EditText)findViewById(R.id.Email_r);
        addData();
        //Intent i = new Intent(Regiser.this, MainActivity.class);
        //startActivity(i);
    }
         //myDb=new DatabaseCHandler(this);
    public void addData() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              //  if (email.getText().length() != 0 && username.getText().length() != 0 && password.getText().length() != 0) {
                    boolean check = mydb.insertData(username.getText().toString(), email.getText().toString(), password.getText().toString());
                    if (check==true) {
                        Toast.makeText(Regiser.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Regiser.this, "Unsuccessful...Try again", Toast.LENGTH_LONG).show();
                    }

              //  }
            }
        });
    }
    }
/*
                   ContentValues contentValues = new ContentValues();


            }
        });
      // initialize();


    }
 /*   public void initialize()
    {
        p_username=username.getText().toString().trim();
        p_email=email.getText().toString().trim();
        p_password=password.getText().toString().trim();
    }*/



