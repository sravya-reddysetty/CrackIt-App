package com.example.sys1.medicineprescriptor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.name;

public class Register extends AppCompatActivity {

    //private static final  R = ;
    Button register;
    EditText email,username,password;
    private String p_email,p_username,p_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        register=(Button)findViewById(R.id.reg);
        email=(EditText)findViewById(R.id.email);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        initialize();
        if(!validate())
        {
            Toast.makeText(this,"SignUp has Failed",Toast.LENGTH_SHORT).show();
        }
        else
        {
            onSignupSuccess();
        }
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Register.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
    public void initialize()
    {
        p_username=username.getText().toString().trim();
        p_email=email.getText().toString().trim();
        p_password=password.getText().toString().trim();
    }
    public void onSignupSuccess()
    {

    }
    public boolean validate()
    {
        boolean valid=true;
        if(p_username.isEmpty()||p_password.isEmpty())
        {
            username.setError("Invalid");
            password.setError("Invalid");
            valid=false;
        }

        return valid;
    }
}
