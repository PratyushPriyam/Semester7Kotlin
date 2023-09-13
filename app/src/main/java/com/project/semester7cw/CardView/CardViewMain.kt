package com.project.semester7cw.CardView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.semester7cw.R

class CardViewMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_view_main)
        supportActionBar?.hide()
    }
}