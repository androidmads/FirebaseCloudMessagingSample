package com.androidmads.firebasecloudmessaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtViewDeviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtViewDeviceId = (TextView) findViewById(R.id.txt_view_device_id);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter(FireBaseInstanceIDService.REGISTRATION_SUCCESS));
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String devId = intent.getStringExtra(FireBaseInstanceIDService.REGISTRATION_TOKEN);
            txtViewDeviceId.setText(devId);
        }
    };

}
