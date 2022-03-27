package com.example.imagecache.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.imagecache.models.Image
import com.example.imagecache.models.SearchAndImage
import com.example.imagecache.models.SearchImage

@Dao
interface SearchDao {
    //SearchImage
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearch(searchImage: SearchImage)

    @Update
    suspend fun updateSearch(searchImage: SearchImage)

    @Delete
    suspend fun deleteSearch(searchImage: SearchImage)

    @Query("SELECT * FROM search_data_table")
    fun getAllSearch():List<SearchImage>

    @Query("SELECT * FROM search_data_table WHERE searchText = :searchText")
    fun getSearchByText(searchText:String):List<SearchImage>


    //Image
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(image: Image)

    @Update
    suspend fun updateImage(image: Image)

    @Delete
    suspend fun deleteImage(image: Image)

    @Query("SELECT * FROM image_data_table WHERE searchText = :searchText")
    fun getImageBySearchText(searchText:String):List<Image>


    //Link
    @Transaction
    @Query("SELECT * FROM search_data_table WHERE searchText=:searchText")
    suspend fun getSearchWithImages(searchText: String):SearchAndImage

}