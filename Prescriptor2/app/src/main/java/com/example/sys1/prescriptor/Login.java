package com.example.sys1.prescriptor;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    TextView tv;
    EditText username, password;
    Button login;
    Cursor res;
    int flag = 1;
    SQLiteDatabase pq;
    public static final String SELECT_SQL = "SELECT * FROM users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pq = openOrCreateDatabase("medicine.db", Context.MODE_PRIVATE, null);
        res= pq.rawQuery(SELECT_SQL, null);
        res.moveToFirst();
        tv = (TextView) findViewById(R.id.ask);
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Password);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Regiser.class);
                startActivity(i);
            }
        });
        login = (Button) findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res.moveToFirst();
                while (res.isAfterLast()==false) {
                    flag = 0;
                    String u=res.getString(0);
                    String user=username.getText().toString();
                    String p=res.getString(2);
                    String pass=password.getText().toString();
                    if (u.equals(user)) {
                        //Toast.makeText(Login.this,username.getText().toString(), Toast.LENGTH_LONG).show();
                        if (p.equals(pass)) {
                            /*Toast.makeText(Login.this, "Successfully Login", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(Login.this, Preview.class);
                            startActivity(i);*/
                            flag=1;
                            break;
                        }
                    }
                    res.moveToNext();
                }
                if(flag==0) {
                    Toast.makeText(Login.this, "Invalid Username or password", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
                else if(flag==1)
                {
                    Toast.makeText(Login.this, "login correct", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Login.this, Users.class);
                    startActivity(i);
                }
                res.close();
        }

        });
    }
    @Override
    public void onBackPressed(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
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









































































      /*  nb.setOnClickListener(new View.OnClickListener() {
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
        String phone = c.getString(2);
        String rent = c.getString(3);
        String jo = c.getString(4);
        tv1.setText("name:"+name);
        tv2.setText("house no:"+house);
        tv3.setText("phone no:"+phone);
        tv4.setText("rent:"+rent);
        tv5.setText("joining date:"+jo);
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
}*/
   /* DatabaseCHandler mydb;
    SQLiteDatabase cq;
    private static final String SELECT_SQL = "select * from details";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cq = openOrCreateDatabase("details.db", Context.MODE_PRIVATE, null);
        tv = (TextView) findViewById(R.id.ask);
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Password);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Regiser.class);
                startActivity(i);
            }
        });
    }
}*/
    /*   login.setOnClickListener(new View.OnClickListener()
        { @Override
            public void onClick(View v) {
            if (res.getCount() == 0) {
                Toast.makeText(Login.this, "Error,Nothing Found", Toast.LENGTH_LONG).show();

            }
            while (res.moveToNext()) {
                flag = 1;
                if (res.getString(0) == username.getText().toString()) {
                    if (res.getString(2) == password.getText().toString()) {
                        Toast.makeText(Login.this, "Successfully Login", Toast.LENGTH_LONG).show();
                        break;
                    } else {
                        Toast.makeText(Login.this, "Wrong Password", Toast.LENGTH_LONG).show();
                        break;
                    }
                } else {
                    flag = 0;
                }

            }
            if (flag == 0) {
                Toast.makeText(Login.this, "Invalid Username", Toast.LENGTH_LONG).show();
            }
*/
           /* res = mydb.getContact();
            if (res.getCount() == 0) {
                Toast.makeText(Login.this, "Error,Nothing Found", Toast.LENGTH_LONG).show();

            }
            while (res.moveToNext()) {
                flag = 1;
                if (res.getString(0) == username.getText().toString()) {
                    if (res.getString(2) == password.getText().toString()) {
                        Toast.makeText(Login.this, "Successfully Login", Toast.LENGTH_LONG).show();
                        break;
                    } else {
                        Toast.makeText(Login.this, "Wrong Password", Toast.LENGTH_LONG).show();
                        break;
                    }
                } else {
                    flag = 0;
                }

            }
            if (flag == 0) {
                Toast.makeText(Login.this, "Invalid Username", Toast.LENGTH_LONG).show();
            }*/

/*        }
        });


    }
}*/
