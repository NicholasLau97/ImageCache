package com.example.imagecache.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.imagecache.R
import com.example.imagecache.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),SearchImageListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val viewModel= ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.searchImageListener = this
    }

    override fun onStarted(){

    }

    override fun onSuccess() {
    }

    override fun onFailure(message: String) {

    }



}