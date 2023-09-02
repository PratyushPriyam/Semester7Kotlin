package com.project.semester7cw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var listView: ListView
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        listView = findViewById(R.id.listView)
        btn = findViewById(R.id.btn)

        var list = mutableListOf<ListModelClass>()

        // WITHOUT CHECKBOX CALLING---------------------------------------------------------
//        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
//        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
//        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
//        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
//        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
//        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
//        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
//        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
//        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_foreground))
        // WITHOUT CHECKBOX CALLING---------------------------------------------------------

        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))
        list.add(ListModelClass("Pratyush", R.drawable.ic_launcher_background, false))

//        btn.setOnClickListener {
//            var str = "Check items: \n"
//            var count = list.count()
//            for(i in 0 until count) {
//                var a = CustomListViewClass(this, R.layout.custom_lisi_view_xml, list)
//                if(a.isChecked(i)) {
//                    str+= """$i""".trimIndent()
//                }
//            }
//            Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
//        }
        btn.setOnClickListener {
            var count = 0;
            var items = ""
            for(i in 0 .. list.size-1) {
                if(list[i].isChecked()) {
                    items += list[i].title
                    count++
                }
            }
            Toast.makeText(this, "count: ${count}", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "items : ${items}", Toast.LENGTH_SHORT).show()
        }


        listView.adapter = CustomListViewClass(this, R.layout.custom_lisi_view_xml, list)

    }
}