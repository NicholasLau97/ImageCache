package com.example.imagecache.models

data class ImagesResponse(
    val _type: String,
    val totalCount: Int,
    val value: List<Value>
)