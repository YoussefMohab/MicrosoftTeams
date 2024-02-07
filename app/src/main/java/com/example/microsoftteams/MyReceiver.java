package com.example.microsoftteams;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
boolean isregesterd = true;
    @Override
    public void onReceive(Context context, Intent intent) {
//        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
//            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
//            if (isAirplaneModeOn) {
//                // Airplane mode is on
//                Toast.makeText(context,"AIRPLANE MODE ON", Toast.LENGTH_LONG).show();
//            } else {
//                // Airplane mode is off
//                Toast.makeText(context,"AIRPLANE MODE OFF",Toast.LENGTH_LONG).show();
//            }
//        } else if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
//            Toast.makeText(context,"POWER CONNECTED",Toast.LENGTH_LONG).show();
//        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
//            Toast.makeText(context,"POWER DISCONNECTED",Toast.LENGTH_LONG).show();
//        }


            switch (intent.getAction()) {
                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
                    if (isAirplaneModeOn) {
                        // Airplane mode is on
                        Toast.makeText(context, "AIRPLANE MODE ON", Toast.LENGTH_LONG).show();
                        break;
                    } else {
                        // Airplane mode is off
                        Toast.makeText(context, "AIRPLANE MODE OFF", Toast.LENGTH_LONG).show();
                        break;
                    }
                case Intent.ACTION_POWER_CONNECTED:
                    Toast.makeText(context, "POWER CONNECTED", Toast.LENGTH_LONG).show();
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    Toast.makeText(context, "POWER DISCONNECTED", Toast.LENGTH_LONG).show();
                    break;
            }



    }

}