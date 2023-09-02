package com.project.semester7cw.BroadcasrReceiverAndJobService

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import android.widget.Toast
import com.project.semester7cw.R

class BRAJSBroadcastReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        var mp = MediaPlayer.create(context, R.raw.defalarm)
        Log.d("Hello", "Repeating Alarm")
        mp.start()
        Toast.makeText(context, "Message", Toast.LENGTH_LONG).show()
    }
}