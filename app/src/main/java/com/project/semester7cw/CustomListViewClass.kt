package com.project.semester7cw

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*

class CustomListViewClass(var cxt: Context, var resource: Int, var objects: MutableList<ListModelClass>):
    ArrayAdapter<ListModelClass>(cxt, resource, objects)
{

    lateinit var cb: CheckBox
    fun isChecked(position: Int): Boolean {
        return objects.get(position).checked
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Getting data using view.
        val layoutInflater = LayoutInflater.from(cxt)
        val view = layoutInflater.inflate(resource, null)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView = view.findViewById<TextView>(R.id.textView)
        val switchBtn = view.findViewById<Button>(R.id.switchBtn)
        val mItem: ListModelClass=objects[position]

        //--------------------------------CHECKBOX START-------------------------------------
        cb = view.findViewById<CheckBox>(R.id.checkBox)
        cb.setChecked(objects.get(position).checked)
        cb.setTag(position)

        var itemStr = objects.get(position).title
        cb.setOnClickListener {
            val newState: Boolean = !objects.get(position).isChecked()
            objects.get(position).checked = newState
            Toast.makeText(cxt, itemStr + "Selected with states: " + newState, Toast.LENGTH_SHORT)
                .show()
            cb.setChecked(isChecked(position))
        }
        //--------------------------------CHECKBOX END-------------------------------------

        // Setting values fetched from view.
        imageView.setImageDrawable(cxt.resources.getDrawable(mItem.img)) // From ListModelClass.
        textView.text = mItem.title // From ListModelClass.

        switchBtn.tag = position
        switchBtn.setOnClickListener {
            val itemSelected = objects.get(it.tag as Int)
            objects.remove(itemSelected)
            notifyDataSetChanged()
        }

        return view
    }



}