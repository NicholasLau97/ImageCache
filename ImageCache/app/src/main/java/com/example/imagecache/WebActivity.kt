package com.example.imagecache

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.imagecache.util.Constants.Companion.WEB_INTENT_KEY_URL

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val web_url: String? = intent.getStringExtra(WEB_INTENT_KEY_URL)

            val myWebView: WebView = findViewById(R.id.wvWeb)
            myWebView.webViewClient = WebViewClient()
            myWebView.apply {
                loadUrl(web_url as String)
                settings.javaScriptEnabled = true
                settings.safeBrowsingEnabled = true
            }


    }

}