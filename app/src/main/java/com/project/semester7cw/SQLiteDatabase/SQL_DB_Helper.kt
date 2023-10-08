package com.project.semester7cw.SQLiteDatabase

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQL_DB_Helper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COL + " TEXT," +
                AGE_COL + " TEXT" + ")")

        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addName(name: String, age: String) {
//        below we are creating a content values variable
        val values = ContentValues()
//        we are inserting out values in the form of key-value pair
        values.put(NAME_COL, name)
        values.put(AGE_COL, age)
//        here we are creating a writable variable of our database as we want to
//        insert value in  our database
        val db = this.writableDatabase
//        all values are inserted into database
        db.insert(TABLE_NAME, null, values)
//        at last we are closing our databse
        db.close()
    }

    fun getName(): Cursor? {
//        here we are creating a readable
//        variable of out databse
//        as we want to read value from it
        val db = this.readableDatabase
//        below code returns a cursor to
//        read data from the database
        return db.rawQuery("SELECT * FROM " +
                TABLE_NAME,  null)
    }

    fun updateDetail(name: String, age: String) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, name)
        values.put(AGE_COL, age)
        db.update(TABLE_NAME, values, "NAME=?", arrayOf(name))
        db.close()
    }

    fun deleteDetail(age: String) {
        val db = this.writableDatabase
        db.delete(TABLE_NAME, "AGE=?", arrayOf(age))
        db.close()
    }

    companion object {
        //        here we have defined variables for out database
//        below is variable for database name
        private val DATABASE_NAME = "CSE226"
        //        below is the variable database version
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "my_table1"
        val ID_COL = "id"
        val NAME_COL = "name"
        val AGE_COL = "age"
    }
}