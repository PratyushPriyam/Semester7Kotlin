package com.project.semester7cw.GridView

class GridModel(val gridTV: String, val gridIV: Int, var isSelected: Boolean) {
    fun isChecked(): Boolean {
        return isSelected
    }
}