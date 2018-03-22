package com.example.sys1.crack_it;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Listview extends AppCompatActivity {

    public static final String EXTRA_COUNTRY = "EXTRA_COUNTRY";
    public ListView listView;

    public MyListAdapter adapter;
    //search code
    public boolean onCreateOptionMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item=menu.findItem(R.id.menusearch);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //initializing objects

        listView = (ListView) findViewById(R.id.listView);
        //creating the adapter
        adapter = new MyListAdapter(this, R.layout.cust);
        listView.setAdapter(adapter);


       //Toast.makeText(getApplicationContext(),getIntent().getExtras().getString("company"),Toast.LENGTH_SHORT).show();
        try {
            showAll(this.findViewById(android.R.id.content));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Toast.makeText(getApplicationContext(), ( Temp.which)-'0',Toast.LENGTH_LONG).show();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //here we can write code to go to another activity to display the answer for the selected question

                Intent i=new Intent(Listview.this,Review.class);
                i.putExtra(EXTRA_COUNTRY, (Serializable) adapter.getItem(position));
                startActivity(i);

            }
        });
    }
    private AsyncTask<Void, Void, Void> runAsyncTask(AsyncTask<Void, Void, Void> task) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            return task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            return task.execute();
        }
    }
   public void showAll(View view) throws ExecutionException, InterruptedException {

       AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>(){
           @Override
           protected Void doInBackground(Void... params) {
               if(Temp.which=="0"){//for branches
               String branch=getIntent().getExtras().getString("Value");
               try {
                   final List<Question> results = Temp.mToDoTable.where()
                           .field("branch").eq(branch).execute().get();

                   runOnUiThread(new Runnable() {

                       @Override
                       public void run() {
                           adapter.clear();
                           for (Question item : results) {
                               if(item.getRating()!=null){
                                   if(item.getRating().startsWith("1")||item.getRating().startsWith("0")){
                                       Temp.mToDoTable.delete(item.getId());
                                       continue;
                                   }
                               }
                               adapter.add(item);
                           }
                       }
                   });
               } catch (Exception exception) {
                   //createAndShowDialog(exception, "Error");
                   Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
               }
              // return null;
                   }
               else if(Temp.which=="1") {
                   String comp= getIntent().getExtras().getString("company");
                   try {
                       final List<Question> results = Temp.mToDoTable.where()
                               .field("company").eq(comp).execute().get();
                       runOnUiThread(new Runnable() {

                           @Override
                           public void run() {
                               adapter.clear();
                               for (Question item : results) {
                                   if(item.getRating()!=null){
                                       if(item.getRating().startsWith("1")||item.getRating().startsWith("0")){
                                           Temp.mToDoTable.delete(item);
                                           continue;
                                       }
                                   }
                                   adapter.add(item);
                               }
                           }
                       });
                   } catch (Exception exception) {
                       //createAndShowDialog(exception, "Error");
                       Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                   }
               }
               else if(Temp.which=="2") {
                   String comp= getIntent().getExtras().getString("r");
                   //String round= getIntent().getExtras().getString("round");
                 //  Toast.makeText(getApplicationContext(),round,Toast.LENGTH_LONG).show();
                   try {
                       final List<Question> results = Temp.mToDoTable.where()
                               .field("rating").ge(comp).execute().get();
                       runOnUiThread(new Runnable() {

                           @Override
                           public void run() {
                               adapter.clear();
                               for (Question item : results) {
                                   if(item.getRating()!=null){
                                       if(item.getRating().startsWith("1")||item.getRating().startsWith("0")){
                                           Temp.mToDoTable.delete(item);
                                           continue;
                                       }
                                   }
                                   adapter.add(item);
                               }
                           }
                       });
                   } catch (Exception exception) {
                       //createAndShowDialog(exception, "Error");
                       Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                   }
               }
                   return null;}


       };
       runAsyncTask(task);
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //search code

            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.menu_search,menu);
            MenuItem item=menu.findItem(R.id.menusearch);
            SearchView searchView=(SearchView)item.getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    adapter.getFilter().filter(s);
                    return false;
                }
            });
            return super.onCreateOptionsMenu(menu);
    }
}
