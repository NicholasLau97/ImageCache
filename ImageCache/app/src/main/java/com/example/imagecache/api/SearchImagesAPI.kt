package com.example.imagecache.api

import com.example.imagecache.models.SearchImagesResponse
import com.example.imagecache.util.Constants.Companion.API_HOST
import com.example.imagecache.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SearchImagesAPI {

    @GET("ImageSearchAPI")
    suspend fun searchImages(
        @Header("X-RapidAPI-Host")
        host:String = API_HOST,
        @Header("X-RapidAPI-Key")
        host_key:String = API_KEY,
        @Query("q")
        q: String = "taylor swift",
        @Query("pageNumber")
        pageNumber: String = "1",
        @Query("pageSize")
        pageSize: String = "10",
        @Query("autoCorrect")
        autoCorrect: String = "true"
    ): Response<SearchImagesResponse>
}