package com.example.muhammadshoaib.azantimings.Activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyAlarm extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /*
        //it will make phone ring on alarm
        Toast.makeText(context,"alarm started",Toast.LENGTH_LONG).show();
*/
        String title = "";
       int azanID = intent.getIntExtra("AZAN_ID",0);

       switch (azanID){

           case 0:
               title = "Fajar";
           break;

           case 1:
               title = "Zuhar";
               break;

           case 2:
               title = "Asar";
               break;

           case 3:
               title = "Maghrib";
               break;

           case 4:
               title = "Isha";
               break;
       }


       //calling the show notification class
        showNotification(context,MainActivity.class,title,title+" time is started");

       //playing azan sound
        MediaPlayer azan= MediaPlayer.create(context,R.raw.azan_in_islam);
        azan.start();

    }


    //this method will show notification and ring alarm sound
    private void showNotification(Context context , Class<?> cls , String title , String content)
    {
        int REQUEST_CODE = 1234567;

        //settting azan in alarm sound object
        Uri alarmSound = Uri.parse("android.resource://" + context.getPackageName() + "/"
                + R.raw.azan_in_islam);

        //initializng intent
        Intent notificationIntent = new Intent(context, cls);

        //setting flags for intent
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        //intitializing task stack builder and adding essential components
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(cls);
        stackBuilder.addNextIntent(notificationIntent);

        //initializing pening intent
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(
                REQUEST_CODE,PendingIntent.FLAG_UPDATE_CURRENT);


        //initializing builder obect and set the builder in notification object
        Notification.Builder builder = new Notification.Builder(context);
        Notification notification = builder.setContentTitle(title)
                .setContentText(content).setAutoCancel(true)
                .setSound(alarmSound).setSmallIcon(R.drawable.mosque)
                .setContentIntent(pendingIntent).build();

        //initializing notification manager and get notification service
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(REQUEST_CODE, notification);



    }

}
