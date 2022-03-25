package com.example.imagecache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "images"
)
data class Value(
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    val base64Encoding: Any,
    val height: Int,
    val imageWebSearchUrl: String,
    val name: String,
    val provider: Provider,
    val thumbnail: String,
    val thumbnailHeight: Int,
    val thumbnailWidth: Int,
    val title: String,
    val url: String,
    val webpageUrl: String,
    val width: Int
):Serializable