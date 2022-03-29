package com.example.imagecache


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.imagecache.databinding.ActivityMainBinding
import com.example.imagecache.db.SearchDatabase
import com.example.imagecache.repository.SearchImagesRepository

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        val searchImagesRepository=SearchImagesRepository(SearchDatabase(this))
        val viewModelProviderFactory = MainViewModelProviderFactory(this,application,searchImagesRepository)

        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)
        binding.viewmodel = viewModel


        viewModel.displayImages.observe(this,{
            it.forEach {
                Log.d("main activity ","image>"+it.thumbnail)
            }
        })





    }
}