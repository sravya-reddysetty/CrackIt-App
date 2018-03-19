package com.example.sys1.crack_it;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

import static com.example.sys1.crack_it.Temp.mclient;

public class SeniorAdd extends AppCompatActivity {
    Button sub,m1,m2,m3,m4,add;
    int t1=0,t2=0,t3=0,t4=0;
    private final int REQ_CODE_SPEECH_OUTPUT=143;
EditText ed,ed2,ed3,ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_add);
        m1=(Button) findViewById(R.id.m1);
        m2=(Button) findViewById(R.id.m2);
        m3=(Button) findViewById(R.id.m3);
        m4=(Button) findViewById(R.id.m4);
        sub=(Button)findViewById(R.id.submit);
        add=(Button)findViewById(R.id.add);
        ed=(EditText)findViewById(R.id.Ques1);
        ed2=(EditText)findViewById(R.id.Ques3);
        ed3=(EditText)findViewById(R.id.Ques2);
        ed4=(EditText)findViewById(R.id.Ques4);
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               t1=1; SPEAK();

            }
        });
        m2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               t2=1; SPEAK();

            }
        });
        m3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t3=1;SPEAK();

            }
        });
        m4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t4=1;SPEAK();

            }
        });
          sub.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if(!(ed.getText().toString().equals(""))) addItem(view, ed);
        if(!(ed2.getText().toString().equals("")))addItem(view,ed2);
        if(!(ed3.getText().toString().equals("")))addItem(view,ed3);
        if(!(ed4.getText().toString().equals(""))) addItem(view,ed4);
        Toast.makeText(getApplicationContext(),"Your Quesions have been recorded.",Toast.LENGTH_LONG).show();
    }
});
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if((ed.getText().toString().equals(""))||ed2.getText().toString().equals("")||ed3.getText().toString().equals("")||ed4.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"Fill the empty fields before adding new questions",Toast.LENGTH_LONG).show();}
                else
               {
                  if((!ed.getText().toString().equals(""))) addItem(view, ed);
                   if(!(ed2.getText().toString().equals("")))addItem(view,ed2);
                   if(!(ed3.getText().toString().equals("")))addItem(view,ed3);
                   if(!(ed4.getText().toString().equals(""))) addItem(view,ed4);
                   Toast.makeText(getApplicationContext(),"Your Quesions have been recorded.",Toast.LENGTH_LONG).show();
               }
            }
        });

        //Toast.makeText(getApplicationContext(),getSpinnerValue,Toast.LENGTH_LONG).show();

    }
    private void SPEAK() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now....");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_OUTPUT);
        } catch (ActivityNotFoundException tim) {
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case REQ_CODE_SPEECH_OUTPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> voiceInText =
                            data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    if(t1==1)
                    {ed.setText(voiceInText.get(0));
                    t1=0; break;}
                    else if(t2==1)
                    {
                        ed2.setText(voiceInText.get(0));
                        t2=0;break;
                    }
                    else if(t3==1)
                    {
                        ed3.setText(voiceInText.get(0));
                        t3=0;break;
                    }
                    else if(t4==1)
                    {
                        ed4.setText(voiceInText.get(0));
                        t4=0;break;
                    }
                }
            }
            break;
        }
    }


        @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Success!!");
        builder.setMessage("Your Questions are recorded.Exit?");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i=new Intent(SeniorAdd.this,MainActivity.class);
                 startActivity(i);
            }
        });
        builder.setNegativeButton("Add more", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
               // MyActivity.super.onBackPressed();
            }});

        builder.show();
    }
    public void addItem(View view,EditText edd) {
        if (mclient == null) {
            return;
        }

        // Create a new item
        final Question item = new Question();
        item.setName(edd.getText().toString());
        String getSpinnerValue=getIntent().getExtras().getString("Value");
        item.setBranch( getSpinnerValue);
        String company=getIntent().getExtras().getString("Val");
        item.setCompany(company);
        //String round=getIntent().getExtras().getString("ro");
        //item.setRound(round);
        item.setRating("4");
        item.n=1;
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final Question entity = addItemInTable(item);
                } catch (final Exception e) {
                  //  createAndShowDialogFromTask(e, "Error");
                }
                return null;
            }
        };

        runAsyncTask(task);
        edd.setText("");

    }
    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }

    /**
     * Add an item to the Mobile Service Table
     *
     * @param item
     *            The item to Add
     */
    public Question addItemInTable(Question item) throws ExecutionException, InterruptedException {
        Question entity = Temp.mToDoTable.insert(item).get();
        return entity;
    }
}


