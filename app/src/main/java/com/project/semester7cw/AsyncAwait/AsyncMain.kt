package com.project.semester7cw.AsyncAwait

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import com.project.semester7cw.R

class AsyncMain : AppCompatActivity() {
    lateinit var progressBar: ProgressBar
    lateinit var listView: ListView
    var arr = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10")
    lateinit var arrayAdapter: ArrayAdapter<String>
    lateinit var arrayList: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_main)

        supportActionBar?.hide()

        progressBar = findViewById(R.id.progressBar)
        listView = findViewById(R.id.ListView)
        arrayList = ArrayList()
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        listView.adapter = arrayAdapter
        MyAsyncTack().execute()
    }
    internal inner class MyAsyncTack: AsyncTask<Void, Int?, String?>() {
        var count = 0
        override fun onPreExecute() {
            super.onPreExecute()
            progressBar.max = 10 // Max Reach
            progressBar.progress = 0 // Initial Start
            progressBar.visibility = View.VISIBLE
            count = 0;
        }
        override fun doInBackground(vararg params: Void?): String? {
            for(i in 1..10) {
                count = count+1
                publishProgress(i)

                try {
                    Thread.sleep(1000)
                }
                catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }
            return "Task Completed"
        }

        override fun onProgressUpdate(vararg values: Int?) {
//            super.onProgressUpdate(*values)
            progressBar.progress = values[0]!!
            arrayList.add(arr[count-1])
            arrayAdapter.notifyDataSetChanged()
        }

        override fun onPostExecute(result: String?) {
//            super.onPostExecute(result)
            Toast.makeText(this@AsyncMain, result , Toast.LENGTH_SHORT).show()
            progressBar.visibility = View.INVISIBLE
        }

    }
}