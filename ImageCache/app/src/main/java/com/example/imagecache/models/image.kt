package com.example.imagecache.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "image"
)
data class image(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val base64Encoding: String,
    val height: Int,
    val imageWebSearchUrl: String,
    val name: String,
    val thumbnail: String,
    val thumbnailHeight: Int,
    val thumbnailWidth: Int,
    val title: String,
    val url: String,
    val webpageUrl: String,
    val width: Int
)
