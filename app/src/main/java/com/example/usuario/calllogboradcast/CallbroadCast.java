package com.example.usuario.calllogboradcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by usuario on 9/02/18.
 */

public class CallbroadCast extends BroadcastReceiver{
    public static final String TAG = "CallbroadCast";
    private static final int CALLNOTIFICATION = 1;


    public CallbroadCast() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG,"as");

        Bundle bundle = new Bundle();

        //1.recoger datos del intent
        if((bundle = intent.getExtras()) != null){
            String state = bundle.getString(TelephonyManager.EXTRA_STATE);
            if(state.equals(TelephonyManager.EXTRA_STATE_IDLE)){

                //1.1 recogemos el numero
                String number = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                //2  ¿À quine le pasamos la informacion?

                Intent newintent = new Intent(context,CallInformation.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("numero","sdfds");
                bundle1.putInt("idNotificacion",CALLNOTIFICATION);
                newintent.putExtras(bundle1);
                PendingIntent pendingIntent = PendingIntent.getActivity(context,CALLNOTIFICATION,newintent,0);

                //3.Crear notificación.
                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

                builder.setContentTitle(TAG);
                builder.setSmallIcon(android.R.drawable.sym_call_incoming);

                builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(),android.R.drawable.sym_call_incoming));

                //3.1 una vez creada vamos ha decirselo anotification manager

                builder.setContentIntent(pendingIntent);
                NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(CALLNOTIFICATION,builder.build());



            }

        }

    }
}
