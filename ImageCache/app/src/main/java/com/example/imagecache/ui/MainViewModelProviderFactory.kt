package com.example.imagecache.ui

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.imagecache.repository.ImagesRepository

class MainViewModelProviderFactory(val app: Application,val imagesRepository: ImagesRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(app,imagesRepository) as T
    }

}
