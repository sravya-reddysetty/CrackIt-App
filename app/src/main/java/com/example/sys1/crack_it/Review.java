package com.example.sys1.crack_it;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Review extends AppCompatActivity {
    TextView textView;
    public List<Question> QuestionList;
    public ListView listView;
    Question ques;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
         ques = (Question) getIntent().getSerializableExtra(Listview.EXTRA_COUNTRY);
        textView = (TextView) findViewById(R.id.tt);
        textView.setText(ques.getName());
        ImageView Button = (ImageView)findViewById(R.id.imageView2);

        Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.google.com/#q="+ques.getName()));
                startActivity(intent);
            }
        });
    }
       /* public void browser1(View view){
            Intent b=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com.kh"));
         startActivity(b);
    }*/
}
