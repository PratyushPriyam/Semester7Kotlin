package com.project.semester7cw.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.semester7cw.R

class Adapter(var list: MutableList<Model>): RecyclerView.Adapter<Adapter.MyHolder>() {
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var genre = itemView.findViewById<TextView>(R.id.genre)
        var year = itemView.findViewById<TextView>(R.id.year)
        var btn = itemView.findViewById<Button>(R.id.btn)

    }
    fun removeItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_layout, parent, false)

        return MyHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = list[position]
        holder.title.text = data.getTitle()
        holder.genre.text = data.getGenre()
        holder.year.text = data.getYear()

    }

    override fun getItemCount(): Int {
        return list.size
    }
}