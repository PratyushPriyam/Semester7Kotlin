package com.project.semester7cw.SQLiteDatabase.EmployeeSalary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.project.semester7cw.R

class EmployeeSalaryMain : AppCompatActivity() {
    lateinit var addEmpBtn: Button
    lateinit var empName: EditText
    lateinit var empID: EditText
    lateinit var empSalary: EditText
    lateinit var empExp: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_salary_main)

        addEmpBtn = findViewById(R.id.addEmpBtn)
        empName = findViewById(R.id.empName)
        empSalary = findViewById(R.id.empSalary)
        empID = findViewById(R.id.empID)
        empExp = findViewById(R.id.empExp)
    }
}