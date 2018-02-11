package com.example.sys1.medicine_prescriptor;

/**
 * Created by sys1 on 10/15/2017.
 */

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v7.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by yoshita on 03-09-2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
   /* Cursor cur;

    private static final String SELECT_ = "SELECT * FROM users";
    SQLiteDatabase sss;
    int p=0;
    RadioButton r;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"pill reminder",Toast.LENGTH_LONG).show();
    }*/

       String s;
       int mNotificationId = 100;
       public void onReceive(Context context, Intent intent) {
           s=intent.getStringExtra("Notify");

           NotificationManager mNotifyMgr =
                   (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
           NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                   .setSmallIcon(R.drawable.pills)
                   .setContentTitle("My notification")
                   .setAutoCancel(true)
                   .setContentText(s)
                   .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));

           mNotifyMgr.notify(mNotificationId, mBuilder.build());
       }
   }

        // context.startActivity(intent);
      /*  sss= context.openOrCreateDatabase("pillreminder.db", Context.MODE_PRIVATE, null);
        cur = sss.rawQuery(SELECT_, null);
        cur.moveToFirst();
        while (!cur.isAfterLast()) {
            String j = cur.getString(4);
            Date today= Calendar.getInstance().getTime();
            SimpleDateFormat sd=new SimpleDateFormat("dd");
            String ff=sd.format(today);
            StringTokenizer st = new StringTokenizer(j, "-");
            String str = st.nextToken();
            Calendar cal=Calendar.getInstance();

            notification(context,cur.getString(0),cur.getString(3) );
            Intent in=new Intent(context,AlarmReceiver.class);
               /* PendingIntent pii=PendingIntent.getActivity(context,0,in,0);
                SmsManager sms=SmsManager.getDefault();
                String msg="pay rent"+cur.getString(3);
                sms.sendTextMessage(cur.getString(2),null,msg,pii,null);
            }*/
           // cur.moveToNext();
        //}
   // }
  /*  void notification(Context context,String yo,String shi) {
        String days="house no:"+yo+" rent:"+shi;
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(context).setSmallIcon(R.drawable.drugs).setContentTitle("Rent reminder").setContentText(days);
        // Add as notification
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Random r=new Random();
        int m=r.nextInt(9999-1000)+1000;
        manager.notify(m, builder.build());
    }*/
//}
