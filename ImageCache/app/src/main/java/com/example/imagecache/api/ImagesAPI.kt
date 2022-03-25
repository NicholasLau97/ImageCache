package com.example.imagecache.api

import com.example.imagecache.models.ImagesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ImagesAPI {
    @GET("ImageSearchAPI")
    suspend fun searchImages():Response<ImagesResponse>
}