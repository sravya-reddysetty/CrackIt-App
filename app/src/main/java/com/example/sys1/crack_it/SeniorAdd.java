package com.example.sys1.crack_it;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import static com.example.sys1.crack_it.Temp.mclient;

public class SeniorAdd extends AppCompatActivity {
    Button sub;
EditText ed,ed2,ed3,ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_add);
        sub=(Button)findViewById(R.id.submit);
        ed=(EditText)findViewById(R.id.Ques1);
        ed2=(EditText)findViewById(R.id.Ques2);
        ed3=(EditText)findViewById(R.id.Ques3);
        ed4=(EditText)findViewById(R.id.Ques4);
sub.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        if(!(ed.getText().toString().equals(""))) addItem(view, ed);
        if(!(ed2.getText().toString().equals("")))addItem(view,ed2);
        if(!(ed3.getText().toString().equals("")))addItem(view,ed3);
        if(!(ed4.getText().toString().equals(""))) addItem(view,ed4);
    }
});
        //Toast.makeText(getApplicationContext(),getSpinnerValue,Toast.LENGTH_LONG).show();

    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Success!!");
        builder.setMessage("Your Questions are recorded. ");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent i=new Intent(SeniorAdd.this,MainActivity.class);
                 startActivity(i);
            }
        });
        builder.setNegativeButton("Add more", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
               // MyActivity.super.onBackPressed();
            }
        });
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
