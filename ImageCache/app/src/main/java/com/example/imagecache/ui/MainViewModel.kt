package com.example.imagecache.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imagecache.models.ImagesResponse
import com.example.imagecache.data.repository.ImageRepository

class MainViewModel(private val repository: ImageRepository):ViewModel() {

    var searchText:String?=null
    var urlWebView:String?=null

    var searchImageListener:SearchImageListener?=null

    val myResponse:MutableLiveData<ImagesResponse> = MutableLiveData()

    fun onSearchBtnClick(view: View){
        searchImageListener?.onStarted()



    }
    fun onWebViewBtnClick(view:View){

    }
}