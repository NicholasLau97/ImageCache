package com.example.imagecache.ui

interface SearchImageListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}