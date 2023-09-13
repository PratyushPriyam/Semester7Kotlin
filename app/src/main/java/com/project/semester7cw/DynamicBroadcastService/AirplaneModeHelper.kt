package com.project.semester7cw.DynamicBroadcastService

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeHelper: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled= intent?.getBooleanExtra("state", false)?:return
        if(isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane Mode Activated", Toast.LENGTH_SHORT).show()
        }
        if(!isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane Mode Deactivated ", Toast.LENGTH_SHORT).show()
        }
    }
}