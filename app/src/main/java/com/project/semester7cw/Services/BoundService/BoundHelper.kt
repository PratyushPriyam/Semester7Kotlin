package com.project.semester7cw.Services.BoundService

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import android.widget.Chronometer

class BoundHelper: Service() {
    private val LOG_TAG = "Bound Service"
    private val mBinder: IBinder = MyBinder()
    private var mChronometer: Chronometer? = null
    override fun onCreate() {
        super.onCreate()
        Log.v(LOG_TAG, "in onCreate")
        mChronometer = Chronometer(this)
        mChronometer!!.base = SystemClock.elapsedRealtime()
        mChronometer!!.start()
    }
    override fun onBind(intent: Intent?): IBinder? {
        return mBinder
    }

    override fun onRebind(intent: Intent?) {
        Log.v(LOG_TAG, "in onRebind")
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.v(LOG_TAG, "in on Unbind")
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(LOG_TAG, "in on Destroy")
        mChronometer!!.stop()
    }

    fun gettimeStamp(): String {
        val elapsedTimeMillis = (SystemClock.elapsedRealtime() - mChronometer!!.base)
        val hours = (elapsedTimeMillis/3600000).toInt()
        val minutes = (elapsedTimeMillis - hours * 3600000).toInt()/6000
        val seconds = (elapsedTimeMillis - hours * 3600000 - minutes * 60000).toInt()/1000
        val millis = (elapsedTimeMillis - hours * 3600000 - minutes * 60000 - seconds * 1000).toInt()

        return "$hours:$minutes:$seconds:$millis"
    }

    inner class MyBinder(): Binder() {
        fun getService(): BoundHelper {
            return this@BoundHelper
        }
    }
}