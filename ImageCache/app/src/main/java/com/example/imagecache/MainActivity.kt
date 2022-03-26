package com.example.imagecache

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.imagecache.databinding.ActivityMainBinding
import com.example.imagecache.repository.SearchImagesRepository

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val searchImagesRepository=SearchImagesRepository()
        val viewModelProviderFactory = MainViewModelProviderFactory(application,searchImagesRepository)

        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)
        binding.viewmodel = viewModel
    }
}