package com.example.imagecache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_data_table")
data class SearchImage(
    @PrimaryKey(autoGenerate = false)
    var searchText:String
)