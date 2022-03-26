package com.example.imagecache.ui

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.imagecache.models.ImagesResponse
import com.example.imagecache.models.Value
import com.example.imagecache.repository.ImagesRepository
import com.example.imagecache.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(app:Application,val repository: ImagesRepository):AndroidViewModel(app) {

    var searchText:String?=null
    var urlWebView:String?=null


    val myResponse:MutableLiveData<ImagesResponse> = MutableLiveData()

    val searchImages:MutableLiveData<Resource<ImagesResponse>> = MutableLiveData()
    var searchImagesResponse:ImagesResponse?=null

    fun onSearchBtnClick(view: View){

        searchImages(searchText)


    }
    fun onWebViewBtnClick(view:View){

    }
    fun searchImages(searchText:String?){

    }
    fun displayImages(images:List<Value>){
        //display the images to infinite recycler view
    }

    suspend fun searchImagesByTextFromAPI(searchText: String){
        searchImages.postValue(Resource.Loading())
        val response = repository.searchImages(searchText,"1","10","true")
        searchImages.postValue(handleSearchImagesResponse(response))
    }
    fun handleSearchImagesResponse(response: Response<ImagesResponse>):Resource<ImagesResponse>{
        if(response.isSuccessful){
            response.body()?.let{resultResponse->
                if(searchImagesResponse == null){
                    searchImagesResponse = resultResponse
                }else{
                    val newImages = searchImagesResponse?.value
                }
                return Resource.Success(searchImagesResponse?:resultResponse)

            }
        }
        return Resource.Error(response.message())
    }
}