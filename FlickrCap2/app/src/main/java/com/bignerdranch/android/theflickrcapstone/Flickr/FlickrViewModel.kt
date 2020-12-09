package com.bignerdranch.android.theflickrcapstone.Flickr

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bignerdranch.android.theflickrcapstone.Photo
import kotlinx.coroutines.launch

class FlickrViewModel: ViewModel(){

    val photosLiveData: MutableLiveData<List<Photo>> = MutableLiveData()
    private val flickrRepository: FlickrRepository = FlickrRepository()

    fun getPhotos(lan: String, lon: String) = viewModelScope.launch {
        if((flickrRepository.getPhoto(lan, lon)).isSuccessful)
            photosLiveData.postValue((flickrRepository.getPhoto(lan, lon)).body()?.photos?.photo)
    }
}