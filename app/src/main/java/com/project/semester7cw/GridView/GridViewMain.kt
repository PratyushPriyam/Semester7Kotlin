package com.project.semester7cw.GridView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.semester7cw.R

class GridViewMain : AppCompatActivity() {
    lateinit var gridLayout: RecyclerView
    lateinit var arrayList: ArrayList<GridModel>
    var adapterGrid: GridAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_main)
        gridLayout = findViewById(R.id.gridLayout)

        gridListData()

        gridLayout.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.orientation = RecyclerView.VERTICAL
        gridLayout.setLayoutManager(gridLayoutManager)
        adapterGrid = GridAdapter(this, arrayList)
        gridLayout.adapter = adapterGrid
    }

    private fun gridListData() {
        arrayList = ArrayList<GridModel>()
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
        arrayList.add(GridModel("Pratyush", R.drawable.ic_launcher_background))
    }
}