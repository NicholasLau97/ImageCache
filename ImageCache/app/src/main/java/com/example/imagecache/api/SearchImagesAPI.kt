package com.example.imagecache.api

import com.example.imagecache.models.SearchImagesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchImagesAPI {

    @GET("ImageSearchAPI")
    suspend fun searchImages(
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