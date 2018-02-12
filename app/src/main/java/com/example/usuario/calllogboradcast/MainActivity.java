package com.example.usuario.calllogboradcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sendIntent(View view){
        Intent intent = new Intent("com.example.usuario.calllogboradcast.intent");
        Bundle bundle = new Bundle();
        bundle.putString(TelephonyManager.EXTRA_STATE,TelephonyManager.EXTRA_STATE_IDLE);
        bundle.putString(TelephonyManager.EXTRA_INCOMING_NUMBER,"6453456312");

        intent.putExtras(bundle);
        sendBroadcast(intent);



    }
}
