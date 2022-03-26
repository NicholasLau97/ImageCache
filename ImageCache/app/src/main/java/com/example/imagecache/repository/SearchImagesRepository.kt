package com.example.imagecache.repository

import com.example.imagecache.api.RetrofitInstance

class SearchImagesRepository {
    suspend fun searchImages(q:String) =
        RetrofitInstance.api.searchImages(q,"1","10","true")
}