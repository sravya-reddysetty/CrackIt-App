package com.example.sys1.prescriptor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class skin extends AppCompatActivity {
    TextView d1,d2,dl1,dl2,dp1,dp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin);
       /* d1=(TextView)findViewById(R.id.sdname1);
        d2=(TextView)findViewById(R.id.sdname2);
        dl1=(TextView)findViewById(R.id.sdloc1);
        dl2=(TextView)findViewById(R.id.sdloc2);
        dp1=(TextView)findViewById(R.id.sdphone1);
        dp2=(TextView)findViewById(R.id.sdphone2);
        d1.setText("Name : Dr.Swetha" );
        d2.setText("Name : Dr.Deepika");
        dl1.setText("Loc : Medak");
        dl2.setText("Loc : Chithoor");
        dp1.setText("Phone-No : 8978912358");
        dp2.setText("Phone-No : 8990909090");*/

    }
    public void onBackPressed(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(skin.this);
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
