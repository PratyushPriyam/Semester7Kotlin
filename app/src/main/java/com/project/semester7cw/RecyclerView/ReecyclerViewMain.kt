package com.project.semester7cw.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.semester7cw.R

class ReecyclerViewMain : AppCompatActivity() {
    lateinit var recView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reecycler_view_main)

        supportActionBar?.hide()

        recView = findViewById(R.id.recView)
        val arrList: ArrayList<Model> = arrayListOf(
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
            Model("Pratyush", "No idea", "2000"),
        )


        val layoutManager = LinearLayoutManager(applicationContext)
        recView.layoutManager = layoutManager
        recView.itemAnimator = DefaultItemAnimator()
        recView.adapter = Adapter(arrList)


    }
}