package com.project.semester7cw.RoomDataBase

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.project.semester7cw.R

class RoomAdapter(var mCxt: Context, var resources: Int, var items: List<Contact>):
    ArrayAdapter<Contact>(mCxt, resources, items){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater = LayoutInflater.from(mCxt)
        val view: View = layoutInflater.inflate(resources, null)
        val name: TextView = view.findViewById(R.id.roomNameEdt)
        val phone: TextView = view.findViewById(R.id.roomPhNoEdt)
        val id: TextView = view.findViewById(R.id.roomIdEdt)

        val mItem: Contact = items[position]
        name.text = mItem.name
        phone.text = mItem.phone.toString()
        id.text = mItem.id.toString()


        return view
    }
}