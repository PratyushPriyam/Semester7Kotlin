package com.project.semester7cw.WebView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.project.semester7cw.R

class StaticMain : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_static_main)

        webView = findViewById(R.id.webView)

        val customHTML = "<html><body><h1>Welcome to Notepad App</h1>" +
                "<h1>Welcome to your personal notes storage </h1> <h3>Welcome to Notepad APP</h3>" +
                "<h3>Here you can store your personal notes</h3>" +
                "</body></html>"

        webView.loadData(customHTML, "text/html", "UTF-8")
    }
}