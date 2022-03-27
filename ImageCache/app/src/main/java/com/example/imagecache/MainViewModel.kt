package com.example.imagecache

import android.app.Application
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagecache.models.*
import com.example.imagecache.repository.SearchImagesRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(app: Application,
                    val searchImagesRepository: SearchImagesRepository): AndroidViewModel(app) {

    var searchText:String=""
    var urlText:String?=null

    var displayImages:MutableLiveData<List<Image>> = MutableLiveData()


    fun onSearchBtnClick(view: View){
        Log.d("View Model","Search btn clicked : $searchText")
        viewModelScope.launch {
            startSearch()
        }
    }

    fun onWebViewBtnClick(view:View){
        Log.d("View Model","Web view btn clicked: $urlText")

    }
    fun searchImages() =viewModelScope.launch {

        val q: String = searchText as String
        val response = searchImagesRepository.searchImages(q)
        handleSearchNewsResponse(response)
        //Log.d("View Model","data: $response")

    }
    suspend fun handleSearchNewsResponse(response: Response<SearchImagesResponse>){
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                var insertedImageData: List<Image> = listOf()
                searchImagesRepository.insertSearch(SearchImage(searchText))
                resultResponse.value.forEach { imageData->

                    val image_data =Image(
                        0,
                        imageData.base64Encoding,
                        imageData.height,
                        imageData.imageWebSearchUrl,
                        imageData.name,
                        imageData.thumbnail,
                        imageData.thumbnailHeight,
                        imageData.thumbnailWidth,
                        imageData.title,
                        imageData.url,
                        imageData.webpageUrl,
                        imageData.width,
                        searchText as String
                    )
                    //Log.d("View Model","insert image : "+image_data.toString())
                    searchImagesRepository.insertImage(image_data)
                    insertedImageData.toMutableList().add(image_data)
                }
                displayImages.value = insertedImageData;
            }
        }else{
            // if API CALL FAILURE
        }
    }
    suspend fun startSearch(){
        val isSearched = isSearched()
        if(isSearched==null){
            searchImages()
        }else{
            displayImages.value = isSearched.image;
        }
    }
    suspend fun isSearched():SearchAndImage?{

         val allimages = searchImagesRepository.getSearchWithImages(searchText)



        if(allimages==null){
            Log.d("view model","search text >>> null")

            return null
        }else{
            Log.d("view model","search text >>>"+ allimages.searchImage.searchText)
            allimages!!.image.forEach{
                Log.d("search images",it.thumbnail)
            }
            return allimages
        }
    }
}