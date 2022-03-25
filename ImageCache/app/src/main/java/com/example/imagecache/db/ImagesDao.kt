package com.example.imagecache.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.imagecache.models.Value

interface ImagesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(image: Value):Long

    @Query("SELECT * FROM images")
    fun getAllImages():LiveData<List<Value>>

    @Delete
    suspend fun deleteArticle(images: Value)
}