package com.project.semester7cw.Services.Service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.project.semester7cw.R

class ServicesMain : AppCompatActivity() {
    lateinit var startServiceBtn: Button
    lateinit var endServiceBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unbounded_services_main)

        startServiceBtn = findViewById(R.id.startServiceBtn)
        endServiceBtn = findViewById(R.id.endServiceBtn)

        startServiceBtn.setOnClickListener {
            Toast.makeText(this, "Service Running", Toast.LENGTH_SHORT).show()
            startService(Intent(this, ServiceHelperClass::class.java))
        }


        endServiceBtn.setOnClickListener { stopService(Intent(this, ServiceHelperClass::class.java)) }
    }
}