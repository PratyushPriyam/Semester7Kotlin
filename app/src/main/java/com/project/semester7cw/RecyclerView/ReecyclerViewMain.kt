package com.project.semester7cw.RecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
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
        val arrList: MutableList<Model> = mutableListOf(
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
        val adapter = Adapter(arrList)
        recView.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == ItemTouchHelper.RIGHT) {
                    // Get the position of the item being swiped
                    val position = viewHolder.adapterPosition
                    // Remove the item from the dataset
                    adapter.removeItem(position)
                }
            }
        })

        itemTouchHelper.attachToRecyclerView(recView)

    }
}