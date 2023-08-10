package com.project.semester7cw

import android.media.Image
import android.widget.Button
import android.widget.CheckBox

class ListModelClass (val title: String, val img: Int, var checked: Boolean) {

    fun isChecked(): Boolean {
        return checked
    }

}