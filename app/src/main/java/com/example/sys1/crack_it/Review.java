package com.example.sys1.crack_it;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Review extends AppCompatActivity {
    TextView textView;
    RatingBar rate;
    String rated;
    Question ques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        ques = (Question) getIntent().getSerializableExtra(Listview.EXTRA_COUNTRY);
        textView = (TextView) findViewById(R.id.tt);
        textView.setText(ques.getName());
        ImageView Button = (ImageView) findViewById(R.id.imageView2);

        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.google.com/#q=" + ques.getName()));
                startActivity(intent);
            }
        });
        rate = (RatingBar) findViewById(R.id.rate);
     //   Toast.makeText(getApplicationContext(),ques.getRating(),Toast.LENGTH_LONG).show();
if(ques.getRating()!=null)
//        String a="1";
  //      if(a!="1")
        {
        rate.setRating(Float.parseFloat(ques.getRating()));
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                rated = String.valueOf(ratingBar.getRating());
                String r = ques.getRating();
                Float p = ((Float.parseFloat(r) * ques.n) + Float.parseFloat(rated)) / (ques.n + 1);
              //  Toast.makeText(getApplicationContext(), Float.toString(p), Toast.LENGTH_LONG).show();
                ques.n = ques.n + 1;
                ques.setRating(Float.toString(p));
                    upda();

            }
        });}
        else{
    rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            ques.setRating(String.valueOf(ratingBar.getRating()));
            ques.n=1;
            upda();
        }
    });
}
    }
    public void upda(){
    AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                final Question entity = updateItemInTable(ques);
            } catch (final Exception e) {
                //  createAndShowDialogFromTask(e, "Error");
            }
            return null;
        }
    };

    runAsyncTask(task);

}
    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }
    public Question updateItemInTable(Question item) throws ExecutionException, InterruptedException {
        Question entity = Temp.mToDoTable.update(item).get();
        return entity;
    }
}
