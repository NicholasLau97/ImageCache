package com.example.imagecache.repository

import com.example.imagecache.api.RetrofitInstance
import com.example.imagecache.util.Constants.Companion.API_HOST
import com.example.imagecache.util.Constants.Companion.API_KEY

class SearchImagesRepository {
    suspend fun searchImages(q:String) =
        RetrofitInstance.api.searchImages(API_HOST, API_KEY,q,"1","10","true")
}