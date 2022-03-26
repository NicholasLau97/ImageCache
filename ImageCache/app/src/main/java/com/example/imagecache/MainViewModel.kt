package com.example.imagecache

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel

class MainViewModel():ViewModel() {

    var searchText:String?=null
    var urlText:String?=null

    fun onSearchBtnClick(view: View){
        Log.d("View Model","Search btn clicked : $searchText")
    }

    fun onWebViewBtnClick(view:View){
        Log.d("View Model","Web view btn clicked: $urlText")

    }
}