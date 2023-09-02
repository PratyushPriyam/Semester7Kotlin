package com.project.semester7cw.Services.UnBoundService

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.project.semester7cw.R

class UnBoundServiceMain : AppCompatActivity() {
    lateinit var startBoundBtn: Button
    lateinit var stopBoundBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound_service_main)
        startBoundBtn = findViewById(R.id.startBoundService)
        stopBoundBtn = findViewById(R.id.stopBoundService)

        startBoundBtn.setOnClickListener {
            val intent = Intent(this, UnBoundServiceHelperClass::class.java)
            intent.putExtra("inputExtra", "Foreground Service is running")
            ContextCompat.startForegroundService(this, intent)
        }

        stopBoundBtn.setOnClickListener {
            val intent = Intent(this, UnBoundServiceHelperClass::class.java)
            stopService(intent)
        }
    }
}