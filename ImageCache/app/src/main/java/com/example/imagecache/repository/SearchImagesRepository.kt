package com.example.imagecache.repository

import com.example.imagecache.api.RetrofitInstance
import com.example.imagecache.db.SearchDatabase
import com.example.imagecache.models.Image
import com.example.imagecache.models.SearchImage
import com.example.imagecache.util.Constants.Companion.API_HOST
import com.example.imagecache.util.Constants.Companion.API_KEY

class SearchImagesRepository(val db:SearchDatabase) {
    suspend fun searchImages(q:String) =
        RetrofitInstance.api.searchImages(API_HOST, API_KEY,q,"1","10","true")

    suspend fun insertSearch(searchImage: SearchImage)=
        db.getImageDao().insertSearch(searchImage)

    suspend fun updateSearch(searchImage: SearchImage)=
        db.getImageDao().updateSearch(searchImage)

    suspend fun deleteSearch(searchImage:SearchImage)=
        db.getImageDao().deleteSearch(searchImage)

    fun getAllSearch()=
        db.getImageDao().getAllSearch()

    fun getSearchByText(searchText:String)=
        db.getImageDao().getSearchByText(searchText)





    suspend fun insertImage(image: Image) =
        db.getImageDao().insertImage(image)

    suspend fun updateImage(image: Image) =
        db.getImageDao().updateImage(image)

    suspend fun deleteImage(image: Image) =
        db.getImageDao().deleteImage(image)

    fun getImageBySearchText(searchText: String) =
        db.getImageDao().getImageBySearchText(searchText)

    suspend fun getSearchWithImages(searchText: String) =
        db.getImageDao().getSearchWithImages(searchText)

}