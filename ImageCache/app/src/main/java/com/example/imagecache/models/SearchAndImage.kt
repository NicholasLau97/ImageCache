package com.example.imagecache.models

import androidx.room.Embedded
import androidx.room.Relation

data class SearchAndImage(
    @Embedded val searchImage:SearchImage,
    @Relation(
        parentColumn = "searchText",
        entityColumn = "searchText"
    )
    val image:List<Image>
)