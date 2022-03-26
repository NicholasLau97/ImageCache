package com.example.imagecache.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.imagecache.R
import com.example.imagecache.databinding.ActivityMainBinding
import com.example.imagecache.db.ImagesDatabase
import com.example.imagecache.repository.ImagesRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val imagesRepository = ImagesRepository(ImagesDatabase(this))
        val viewModelProviderFactory = MainViewModelProviderFactory(application,imagesRepository)
        val viewModel= ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)
        binding.viewmodel = viewModel

    }




}