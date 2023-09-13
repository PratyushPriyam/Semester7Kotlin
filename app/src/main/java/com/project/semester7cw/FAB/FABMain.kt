package com.project.semester7cw.FAB

import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import android.view.animation.ScaleAnimation
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.semester7cw.R


class FABMain : AppCompatActivity() {
    lateinit var addFAB: FloatingActionButton
    lateinit var supportFAB: FloatingActionButton
    lateinit var timeFAB: FloatingActionButton
    var fabVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fabmain)
        
        addFAB = findViewById(R.id.addFAB)
        supportFAB = findViewById(R.id.supportFAB)
        timeFAB = findViewById(R.id.timeFAB)
        fabVisible = false
        
        addFAB.setOnClickListener { 
            if(!fabVisible) {
                supportFAB.show()
                timeFAB.show()
                val anim = ScaleAnimation(0F, 1F, 0F, 1F)
                anim.fillBefore = true
                anim.fillAfter = true
                anim.isFillEnabled = true
                anim.duration = 300
                anim.interpolator = OvershootInterpolator()
                addFAB.animation = anim
                supportFAB.visibility = View.VISIBLE
                timeFAB.visibility = View.VISIBLE
                addFAB.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_close_24))
                fabVisible = true
            }
            else {
                supportFAB.hide()
                timeFAB.hide()
                supportFAB.visibility = View.GONE
                timeFAB.visibility = View.GONE
                val anim = ScaleAnimation(0F, 1F, 0F, 1F)
                anim.fillBefore = true
                anim.fillAfter = true
                anim.isFillEnabled = true
                anim.duration = 300
                anim.interpolator = OvershootInterpolator()
                addFAB.animation = anim
                addFAB.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_add_24))
                fabVisible = false
            }
        }
        timeFAB.setOnClickListener {
            Toast.makeText(this, "Time Accessed", Toast.LENGTH_SHORT).show()
        }
        
        supportFAB.setOnClickListener {
            Toast.makeText(this, "Support Accessed", Toast.LENGTH_SHORT).show()
        }
    }
}