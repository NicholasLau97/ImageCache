package com.example.imagecache.repository

import com.example.imagecache.api.RetrofitInstance
import com.example.imagecache.db.ImagesDatabase
import com.example.imagecache.models.SearchImages
import com.example.imagecache.models.Value
import retrofit2.http.Query

class ImagesRepository(val db:ImagesDatabase) {

    suspend fun searchImages(q: String,pageNumber: String ,pageSize: String,autoCorrect: String) =
        RetrofitInstance.api.searchImages(q,pageNumber,pageSize,autoCorrect)

    suspend fun upsert(image: SearchImages) = db.getImagesDao().upsert(image)

    fun getSavedImages() = db.getImagesDao().getAllImages()

    suspend fun deleteImage(image:SearchImages) = db.getImagesDao().deleteImages(image)
}