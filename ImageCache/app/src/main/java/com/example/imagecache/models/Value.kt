package com.example.imagecache.models

data class Value(
    val base64Encoding: String,
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
)