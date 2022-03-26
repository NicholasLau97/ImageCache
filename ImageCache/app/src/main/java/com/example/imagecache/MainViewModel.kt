package com.example.imagecache

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagecache.repository.SearchImagesRepository
import kotlinx.coroutines.launch

class MainViewModel(app: Application,
                    val searchImagesRepository: SearchImagesRepository): AndroidViewModel(app) {

    var searchText:String?=null
    var urlText:String?=null

    fun onSearchBtnClick(view: View){
        Log.d("View Model","Search btn clicked : $searchText")
        searchImages()
    }

    fun onWebViewBtnClick(view:View){
        Log.d("View Model","Web view btn clicked: $urlText")

    }
    fun searchImages() =viewModelScope.launch {

        val q: String = searchText as String
        val response = searchImagesRepository.searchImages(q)
        Log.d("View Model","data: $response")

    }
}