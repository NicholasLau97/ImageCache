package com.example.imagecache


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagecache.databinding.ActivityMainBinding
import com.example.imagecache.db.SearchDatabase
import com.example.imagecache.models.Image
import com.example.imagecache.repository.SearchImagesRepository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var imageRecyclerView:RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter:ImageRecyclerViewAdapter

    private var isListItemClicked = false
    private lateinit var selectedImage:Image

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        val searchImagesRepository=SearchImagesRepository(SearchDatabase(this))
        val viewModelProviderFactory = MainViewModelProviderFactory(this,application,searchImagesRepository)

        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(MainViewModel::class.java)
        binding.viewmodel = viewModel

        imageRecyclerView = binding.rvImage
        initRecyclerView()
    }

    private fun initRecyclerView() {

        layoutManager = LinearLayoutManager(this)
        imageRecyclerView.layoutManager = layoutManager
        imageRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = adapter.itemCount
                if((visibleItemCount as Int + pastVisibleItem as Int)>=total as Int ){

                    var images:List<Image>? = viewModel.displayImages.value
                    if (images != null) {
                        viewModel.displayImages.value?.forEach {
                            images+=it
                        }
                    }
                    viewModel.displayImages.value=images
                    Log.d("RV","here... ${viewModel.displayImages.value.toString()}")


                }

                Log.d("RV","visible itemcount $visibleItemCount pastVisibleItem $pastVisibleItem total $total")

                super.onScrolled(recyclerView, dx, dy)
            }
        })
        adapter = ImageRecyclerViewAdapter { selectedItem: Image ->
            listItemClicked(selectedItem)
        }
        imageRecyclerView.adapter = adapter
        displayImagesList()
    }

    private fun displayImagesList() {
        viewModel.displayImages.observe(this,{
            adapter.setList(it)
            adapter.notifyDataSetChanged()
            it.forEach {
                Log.d("main activity ","image>"+it.thumbnail)
            }
        })
    }
    private fun listItemClicked(image: Image) {
        Log.d("Main Activity",image.searchText+">"+image.thumbnail)

        var inflater = LayoutInflater.from(this)
        var popupview = inflater.inflate(R.layout.pop_up,null,false)
        var imagePopup = popupview.findViewById<ImageView>(R.id.imgPopup)
        Glide.with(this)
            .load(image.url)
            .centerCrop()
            .into(imagePopup)
        var close = popupview.findViewById<Button>(R.id.btnBack)
        var builder = PopupWindow(popupview,LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT,true)
        builder.setBackgroundDrawable(getDrawable(R.drawable.pop_up_background))
        builder.showAtLocation(this.findViewById(R.id.parentview),Gravity.CENTER,0,0)
        close.setOnClickListener {
            builder.dismiss()
        }


    }
}