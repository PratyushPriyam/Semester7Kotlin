package com.project.semester7cw.RoomDataBase

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.room.Room
import com.project.semester7cw.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomDatabaseMain : AppCompatActivity() {
    lateinit var roomAddBtn: Button
    lateinit var roomDisplayBtn: Button
    lateinit var roomListView: ListView
    lateinit var roomNameEdt: EditText
    lateinit var roomIdEdt: EditText
    lateinit var roomPhNoEdt: EditText
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_database_main)

//        roomAddBtn = findViewById(R.id.roomAddBtn)
//        roomDisplayBtn = findViewById(R.id.roomDelBtn)
//        roomListView = findViewById(R.id.roomListView)
//        roomNameEdt = findViewById(R.id.roomNameEdt)
//        roomIdEdt = findViewById(R.id.roomIdEdt)
//        roomPhNoEdt = findViewById(R.id.roomPhNoEdt)
//
//        database = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "contactDB").build()
//        roomListView.setOnItemLongClickListener{parent, view, position, id ->
//            val view = parent.get(position)
//            val id = roomIdEdt.text.toString()
//            val name = roomNameEdt.text.toString()
//            val phNo = roomPhNoEdt.text.toString()
//            var builder = AlertDialog.Builder(this)
//            builder.setTitle("Edit")
//            var linearLayout = LinearLayout(this)
//            linearLayout.orientation = LinearLayout.VERTICAL
//            val idView = EditText(this)
//            idView.setText(id.toString())
//            linearLayout.addView(idView)
//            val nameView = EditText(this)
//            nameView.text.clear()
//            nameView.setText(name)
//            linearLayout.addView(nameView)
//            val phoneView = EditText(this)
//            phoneView.text.clear()
//            phoneView.setText(phoneView.toString())
//
//            builder.setView(linearLayout)
//            builder.setPositiveButton("Edit", DialogInterface.OnClickListener{
//                dialog, which ->
//                val updatedName = nameView.text.toString()
//                val updatedPhone = phoneView.text.toString().toLong()
//                GlobalScope.launch {
//                    database.ContactDao().update(Contact(id, updatedName, updatedPhone))
//                }
//            } {
//                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
//            })
//
//            builder.setNegativeButton("Cancel", DialogInterface.OnClickListener {
//                Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
//            })
//
//            builder.show()
//            return@setOnItemLongClickListener true
//        }


    }
}