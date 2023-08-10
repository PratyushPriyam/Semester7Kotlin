package com.project.semester7cw.GridView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.semester7cw.R

class GridAdapter(var cxt: Context, var list: ArrayList<GridModel>): RecyclerView.Adapter<GridAdapter.GridHolder>() {
    class GridHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var gridTV: TextView
        var gridIV: ImageView

        init {
            gridTV = itemView.findViewById(R.id.gridTV)
            gridIV = itemView.findViewById(R.id.gridIV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHolder {
        val v: View = LayoutInflater.from(cxt).inflate(R.layout.activity_grid_view_main, parent)
        return GridHolder(v)
    }

    override fun onBindViewHolder(holder: GridHolder, position: Int) {
//        holder.gridIV.text = list[position].name
    }

    override fun getItemCount(): Int {
        return list.size
    }
}