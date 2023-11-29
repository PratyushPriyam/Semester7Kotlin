package com.project.semester7cw.WebView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import com.project.semester7cw.R

class Dynamic : AppCompatActivity() {
    lateinit var webViewDynamic: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic)

        webViewDynamic = findViewById(R.id.webViewDynamic)

        val url = "https://lukup.netlify.app/"

        val webSettings: WebSettings = webViewDynamic.settings

        webSettings.javaScriptEnabled = true

        webViewDynamic.loadUrl(url)
    }
}