package com.example.imagecache.models

data class SearchImagesResponse(
    val _type: String,
    val totalCount: Int,
    val value: List<Value>
)