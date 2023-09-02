package com.project.semester7cw.DynamicBroadcastService

import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.semester7cw.R

class DBRMain : AppCompatActivity() {
    lateinit var receiver: DBRHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbrmain)
        receiver = DBRHelper()
        IntentFilter(WifiManager.NETWORK_STATE_CHANGED_ACTION).also {
            registerReceiver(receiver, it)
        }
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}