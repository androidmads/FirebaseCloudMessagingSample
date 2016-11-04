package com.androidmads.firebasecloudmessaging;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FireBaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = FireBaseInstanceIDService.class.getSimpleName();
    public static final String REGISTRATION_SUCCESS = "RegistrationSuccess";
    public static final String REGISTRATION_TOKEN = "token";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed_token: " + refreshedToken);

        Intent intent1 = new Intent(REGISTRATION_SUCCESS);
        intent1.putExtra(REGISTRATION_TOKEN, refreshedToken);
        sendBroadcast(intent1);
    }

}