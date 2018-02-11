package com.example.sys1.medicine_prescriptor;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by sys1 on 10/11/2017.
 */

public class EditFragment extends android.support.v4.app.Fragment {
    private static final String TAG="EditFragment";
    Button add;
    SQLiteDatabase sq;

    EditText et1, et2, et3,et4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.edit_fragment,container,false);
        sq = getContext().openOrCreateDatabase("pillreminder.db", Context.MODE_PRIVATE, null);//mode private means only u can use it
        sq.execSQL("create table if not exists users (" +
                " symptoms TEXT NOT NULL,medicines TEXT NOT NULL ,doctor TEXT NOT NULL,phone TEXT NOT NULL)");
        add = (Button)view.findViewById(R.id.Add);
        et1 = (EditText)view.findViewById(R.id.symptoms);
        et2 = (EditText)view.findViewById(R.id.medicines);
        et3 = (EditText)view.findViewById(R.id.doctor_name);
        et4 = (EditText)view.findViewById(R.id.phone);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().length()==0||et2.getText().toString().length()==0||et3.getText().toString().length()==0||et4.getText().toString().length()==0){
                    Toast.makeText(getActivity(), "Please fill the empty fields", Toast.LENGTH_LONG).show();
                    return;
                }
                ContentValues val = new ContentValues();
                val.put("symptoms", et1.getText().toString());//attribute name in the table is used as key
                val.put("medicines", et2.getText().toString());
                val.put("doctor", et3.getText().toString());
                val.put("phone", et4.getText().toString());
                long count = sq.insert("users", null, val);
                if (count > 0) {
                    Toast.makeText(getActivity(), "Successful addition", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "Unsuccessful addition..Try Again ", Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
    public void onBackPressed(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage("Want to EXIT ?");
        builder.setCancelable(true);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // dialog.cancel();
                getActivity().finish();

            }
        });
        builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
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
