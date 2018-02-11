package com.example.sys1.medicine_prescriptor;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sys1 on 10/11/2017.
 */

public class Details_Fragment extends android.support.v4.app.Fragment {
    private static final String TAG = "EditFragment";

    SQLiteDatabase pq;
    Button pb, nb;
    TextView tv1, tv2, tv3, tv4,tv5;
    private Cursor c;
    private static final String SELECT_SQL = "SELECT * FROM users";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_fragment, container, false);
        pq = getActivity().openOrCreateDatabase("pillreminder.db", Context.MODE_PRIVATE, null);
        tv1 = (TextView) view.findViewById(R.id.sym);
        tv2 = (TextView) view.findViewById(R.id.med);
        tv3 = (TextView) view.findViewById(R.id.doctor);
        tv4 = (TextView) view.findViewById(R.id.num);
        tv5=(TextView)view.findViewById(R.id.textView12);
        //c = pq.rawQuery(SELECT_SQL, null);
        pb = (Button) view.findViewById(R.id.back);
        nb = (Button) view.findViewById(R.id.next);

        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movePrev();
            }
        });
        nb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveNext();
            }
        });
        c = pq.rawQuery(SELECT_SQL, null);
        c.moveToFirst();
        showRecords();
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "tel:" + c.getString(3);
               /* Intent call = new Intent(Intent.ACTION_CALL);
                call.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                call.setData(Uri.parse(number));*/
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse(number));
                getActivity().startActivity(call);
            }
        });
        return view;
    }
    protected void showRecords() {
        String symptoms = c.getString(0);
        String medicines = c.getString(1);
        String name = c.getString(2);
        String number = c.getString(3);
        tv1.setText("Symptoms : "+symptoms);
        tv2.setText("Medicines :"+medicines);
        tv3.setText("Doctor :"+name);
        tv4.setText("Number :"+number);

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
}


