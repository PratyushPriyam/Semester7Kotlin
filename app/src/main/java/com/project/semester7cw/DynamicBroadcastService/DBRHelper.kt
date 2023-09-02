package com.project.semester7cw.DynamicBroadcastService

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class DBRHelper: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled= intent?.getBooleanExtra("state", false)?:return
        if(isAirplaneModeEnabled) {
            Toast.makeText(context, "Toast Activated", Toast.LENGTH_SHORT).show()
        }
//        if(!isAirplaneModeEnabled) {
//            Toast.makeText(context, "Toast shut down", Toast.LENGTH_SHORT).show()
//        }


        val isWiFIEnabled = intent.getBooleanExtra("wifiState", false)?:return

        if(isWiFIEnabled) {
            Toast.makeText(context, "Wifi enabled", Toast.LENGTH_SHORT).show()
        }
    }
}