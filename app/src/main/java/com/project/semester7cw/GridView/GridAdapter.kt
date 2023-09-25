package com.project.semester7cw.GridView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.project.semester7cw.R

class GridAdapter(var cxt: Context, var list: ArrayList<GridModel>): RecyclerView.Adapter<GridAdapter.GridHolder>() {
    lateinit var cb: CheckBox
    fun isChecked(position: Int): Boolean {
        return list.get(position).isSelected
    }
    class GridHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var gridTV: TextView
//        var gridIV: ImageView

        init {
            gridTV = itemView.findViewById(R.id.gridTV)
//            gridIV = itemView.findViewById(R.id.gridIV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridHolder {
        val v: View = LayoutInflater.from(cxt).inflate(R.layout.grid_custom_layout, parent, false)
        cb = v.findViewById<CheckBox>(R.id.cb2)

        return GridHolder(v)
    }

    override fun onBindViewHolder(holder: GridHolder, position: Int) {
        holder.gridTV.text = list[position].gridTV
//        holder.gridIV.setImageResource(list[position].gridIV)
        //--------------------------------CHECKBOX START-------------------------------------
        cb.isChecked = list[position].isChecked()
        cb.tag = position
        cb.isChecked = list[position].isSelected
        cb.tag = position

        var itemStr = list[position].gridTV
        cb.setOnClickListener {
            val newState: Boolean = !list[position].isChecked()
            list[position].isSelected = newState
            cb.isChecked = isChecked(position)
        }
        //--------------------------------CHECKBOX END-------------------------------------
    }

    override fun getItemCount(): Int {
        return list.size
    }
}