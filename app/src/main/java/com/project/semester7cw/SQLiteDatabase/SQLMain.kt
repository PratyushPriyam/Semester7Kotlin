package com.project.semester7cw.SQLiteDatabase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.project.semester7cw.R

class SQLMain : AppCompatActivity() {
    lateinit var dbEt1: EditText
    lateinit var dbEt2: EditText
    lateinit var dbTv1: TextView
    lateinit var dbTv2: TextView
    lateinit var dbAdd: Button
    lateinit var dbShow: Button
    lateinit var dbUpdate: Button
    lateinit var dbDelete: Button
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlmain)

        dbEt1 = findViewById(R.id.dbEt1)
        dbEt2 = findViewById(R.id.dbEt2)
        dbTv1 = findViewById(R.id.dbTv1)
        dbTv2 = findViewById(R.id.dbTv2)
        dbAdd = findViewById(R.id.dbAdd)
        dbShow = findViewById(R.id.dbShow)
        dbUpdate= findViewById(R.id.dbUpdate)
        dbDelete = findViewById(R.id.dbDelete)

        dbAdd.setOnClickListener {
            val name = dbEt1.text.toString()
            val age = dbEt2.text.toString()


            val db = SQL_DB_Helper(this, null)
            db.addName(name, age)


            Toast.makeText(this, name + " added to database", Toast.LENGTH_SHORT)
                .show()
            dbEt1.text.clear()
            dbEt2.text.clear()
        }


        dbShow.setOnClickListener {

            // creating a DBHelper class
            // and passing context to it
            val db = SQL_DB_Helper(this, null)

            // below is the variable for cursor
            // we have called method to get
            // all names from our database
            // and add to name text view
            val cursor = db.getName()
            dbTv1.text = "Name\n\n"
            dbTv2.text = "Age\n\n"
            // moving the cursor to first position and
            // appending value in the text view
            cursor!!.moveToFirst()
            dbTv1.append(
                cursor.getString(cursor.getColumnIndex(SQL_DB_Helper.NAME_COL))
                        + "\n"
            )
            dbTv2.append(
                cursor.getString(cursor.getColumnIndex(SQL_DB_Helper.AGE_COL))
                        + "\n"
            )
            // moving our cursor to next
            // position and appending values
            while (cursor.moveToNext()) {
                dbTv1.append(
                    cursor.getString(
                        cursor.getColumnIndex
                            (SQL_DB_Helper.NAME_COL)
                    ) + "\n"
                )
                dbTv2.append(
                    cursor.getString
                        (cursor.getColumnIndex(SQL_DB_Helper.AGE_COL)) + "\n"
                )
            }
            // at last we close our cursor
            cursor.close()
        }

        dbUpdate.setOnClickListener {
            val dbHandler = SQL_DB_Helper(this, null)
            dbHandler.updateDetail(dbEt1.text.toString(), dbEt2.text.toString())
            Toast.makeText(this, "Updation Successful", Toast.LENGTH_SHORT).show()
        }

        dbDelete.setOnClickListener {
            val dbHandler = SQL_DB_Helper(this, null)
            dbHandler.deleteDetail(dbEt2.text.toString())
            Toast.makeText(this, "Item Deleted Successfully", Toast.LENGTH_SHORT).show()
        }
    }

}
