package com.example.sys1.medicine_prescriptor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Created by sys1 on 10/11/2017.
 */

public class Notification_Fragment extends android.support.v4.app.Fragment {
    private static final String TAG="EditFragment";
    private TimePicker tp1;
    private Calendar cal;
    public AlarmManager alarmMgr,alm;
    public PendingIntent alarmIntent;
    EditText ed;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.notification_fragment,container,false);
        cal = Calendar.getInstance();



        return view;


    }
}
