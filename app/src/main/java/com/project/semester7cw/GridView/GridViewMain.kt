package com.project.semester7cw.GridView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.semester7cw.R

class GridViewMain : AppCompatActivity() {
    lateinit var gridLayout: RecyclerView
    lateinit var arrayList: ArrayList<GridModel>
    var adapterGrid: GridAdapter? = null
    lateinit var btn: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view_main)
        gridLayout = findViewById(R.id.gridLayout)
        btn = findViewById(R.id.appBtn)

        gridListData()

        gridLayout.setHasFixedSize(true)
        val gridLayoutManager = GridLayoutManager(this, 2)
        gridLayoutManager.orientation = RecyclerView.VERTICAL
        gridLayout.setLayoutManager(gridLayoutManager)
        adapterGrid = GridAdapter(this, arrayList)


        btn.setOnClickListener {
            var count = 0;
            var items = ""
            for(i in 0 .. arrayList.size-1) {
                if(arrayList[i].isChecked()) {
                    items += arrayList[i].gridTV
                    count++
                }
            }
            Toast.makeText(this, "count: ${count}", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "items : ${items}", Toast.LENGTH_SHORT).show()
        }


        gridLayout.adapter = adapterGrid
    }

    private fun gridListData() {
        arrayList = ArrayList<GridModel>()
        arrayList.add(GridModel("Item1", R.drawable.ic_launcher_background, false))
        arrayList.add(GridModel("Item2", R.drawable.ic_launcher_background, false))
        arrayList.add(GridModel("Item3", R.drawable.ic_launcher_background, false))
        arrayList.add(GridModel("Item4", R.drawable.ic_launcher_background, false))
        arrayList.add(GridModel("Item5", R.drawable.ic_launcher_background, false))
    }
}