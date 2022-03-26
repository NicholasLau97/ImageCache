package com.example.imagecache.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.imagecache.R
import com.example.imagecache.databinding.ActivityMainBinding
import com.example.imagecache.repository.ImagesRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val imagesRepository = ImagesRepository()
        val viewModelProviderFactory = MainViewModelProviderFactory(application,imagesRepository)
        val viewModel= ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)
        binding.viewmodel = viewModel

    }




=======
import com.example.imagecache.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
>>>>>>> parent of a6ab4ad (Intial settings)
}