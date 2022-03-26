package com.example.imagecache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "search"
)
data class SearchImages (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val searchText:String
):Serializable