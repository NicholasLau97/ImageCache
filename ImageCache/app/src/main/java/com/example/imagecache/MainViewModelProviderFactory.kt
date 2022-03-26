package com.example.imagecache

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imagecache.repository.SearchImagesRepository

class MainViewModelProviderFactory(
    val app: Application,
    val searchImagesRepository: SearchImagesRepository
    ):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(app, searchImagesRepository) as T
    }
}