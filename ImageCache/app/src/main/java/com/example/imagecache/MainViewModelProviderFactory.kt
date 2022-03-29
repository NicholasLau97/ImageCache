package com.example.imagecache

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imagecache.repository.SearchImagesRepository

class MainViewModelProviderFactory(
    val context: Context,
    val app: Application,
    val searchImagesRepository: SearchImagesRepository
    ):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(context,app, searchImagesRepository) as T
    }
}