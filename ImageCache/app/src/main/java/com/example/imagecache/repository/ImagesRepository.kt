package com.example.imagecache.repository

import com.example.imagecache.api.RetrofitInstance

class ImagesRepository() {

    suspend fun searchImages(q: String,pageNumber: String ,pageSize: String,autoCorrect: String) =
        RetrofitInstance.api.searchImages(q,pageNumber,pageSize,autoCorrect)


}