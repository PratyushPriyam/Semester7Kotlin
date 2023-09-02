package com.project.semester7cw.Services.BoundService

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.project.semester7cw.R

class BoundMain : AppCompatActivity() {
    var mServiceBound = false
    var mBoundService: BoundHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound_main)
        var tvBound = findViewById<TextView>(R.id.tvBound)
        var buttonStart = findViewById<Button>(R.id.buttonStart)
        var buttonEnd = findViewById<Button>(R.id.buttonEnd)

        buttonStart.setOnClickListener {
            if(mServiceBound) {
                tvBound.text = mBoundService!!.gettimeStamp()
            }
        }
        buttonEnd.setOnClickListener {
            if(mServiceBound) {
                unbindService(mServiceConnection)
                mServiceBound = false
            }
            val intent = Intent(this, BoundHelper::class.java)
            stopService(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, BoundHelper::class.java)
        startService(intent)
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        if(mServiceBound){
            unbindService(mServiceConnection)
            mServiceBound=false
        }
    }
    val mServiceConnection: ServiceConnection = object: ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val myBinder: BoundHelper.MyBinder = service  as BoundHelper.MyBinder
            mBoundService = myBinder.getService()
            mServiceBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mServiceBound = false

        }

    }
}