package com.example.sys1.medicineprescriptor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button blogin;
    EditText username,password;
    TextView ask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        ask=(TextView)findViewById(R.id.ask);
        ask.setOnClickListener(this);
        blogin =(Button)findViewById(R.id.log);
        blogin.setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.login:


                break;
            case R.id.ask:
                startActivity(new Intent(this,Register.class));
                break;


        }
    }
}
