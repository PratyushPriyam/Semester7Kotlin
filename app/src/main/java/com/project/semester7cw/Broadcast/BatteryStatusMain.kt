package com.project.semester7cw.Broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.BatteryManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.project.semester7cw.R

class BatteryStatusMain : AppCompatActivity() {
    lateinit var batteryManager: BatteryManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_battery_status_main)

        // Declare button, that will show battery percentage when clicked
//        val btn = findViewById<Button>(R.id.btteryBtn)

        batteryStatusReceiver

    }

    private val batteryStatusReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        @RequiresApi(Build.VERSION_CODES.M)
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "YO", Toast.LENGTH_SHORT).show()
            val level: Int = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
            val scale: Int = intent?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1
            val batteryPct = (level.toFloat() / scale.toFloat()) * 100

            val threshold = 20 // Set your desired battery level threshold here
            if (batteryPct < threshold) {
                val message = "Battery level is low: ${batteryPct.toInt()}%"
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}