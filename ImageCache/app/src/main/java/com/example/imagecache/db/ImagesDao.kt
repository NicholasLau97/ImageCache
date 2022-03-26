package com.example.imagecache.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.imagecache.models.SearchImages
import com.example.imagecache.models.Value

interface ImagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(images: SearchImages):Long

    @Query("SELECT * FROM search")
    fun getAllImages():LiveData<List<SearchImages>>

    @Delete
    suspend fun deleteImages(images: SearchImages)
}