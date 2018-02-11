package com.example.sys1.prescriptor;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sys1 on 9/29/2017.
 */

public class Doctors extends Fragment{
    View v;
    Button h,s,b;
    TextView d1,dl1,dp1,d2,dl2,dp2;
    private Doctors Current=this;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.doctors,container,false);
        h=(Button)v.findViewById(R.id.heart);
        s=(Button)v.findViewById(R.id.skin);
        b=(Button)v.findViewById(R.id.brain);

        h.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "heart!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(),Details.class);
                getActivity().startActivity(i);
            }
        });
       s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "skin!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(),Skindoc.class);
                getActivity().startActivity(i);

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "brain!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(),Braindoc.class);
                getActivity().startActivity(i);
            }
        });
        return v;
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
