package com.example.imagecache.repository

import com.example.imagecache.api.RetrofitInstance
import com.example.imagecache.db.ImagesDatabase
import com.example.imagecache.models.Value

class ImagesRepository(val db:ImagesDatabase) {

    suspend fun searchImages() = RetrofitInstance.api.searchImages()

    suspend fun upsert(image: Value) = db.getImagesDao().upsert(image)

    fun getSavedImages() = db.getImagesDao().getAllImages()

    suspend fun deleteImage(image:Value) = db.getImagesDao().deleteArticle(image)
}