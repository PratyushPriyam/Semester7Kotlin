package com.project.semester7cw.SQLiteDatabase.EmployeeSalary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.project.semester7cw.SQLiteDatabase.SQL_DB_Helper

class EmployeeSalaryDataBase(context: Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, "EmployeeSalaryDB", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

//        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}