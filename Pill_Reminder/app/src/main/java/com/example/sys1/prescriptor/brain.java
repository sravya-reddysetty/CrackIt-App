package com.example.sys1.prescriptor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class brain extends AppCompatActivity {
    TextView d1,d2,dl1,dl2,dp1,dp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain);
    }
    public void onBackPressed(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(brain.this);
        builder.setMessage("Want to EXIT ?");
        builder.setCancelable(true);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // dialog.cancel();
                finish();

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
