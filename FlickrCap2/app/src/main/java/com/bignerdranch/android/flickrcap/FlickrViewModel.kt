package com.bignerdranch.android.theflickrcapstone

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FlickrViewModel: ViewModel(){

    val photosLiveData: MutableLiveData<List<Photo>> = MutableLiveData()
    private val flickrRepository: FlickrRepository = FlickrRepository()

    fun getPhotos(lan: String, lon: String) = viewModelScope.launch {
        if((flickrRepository.getPhoto(lan, lon)).isSuccessful)
            photosLiveData.postValue((flickrRepository.getPhoto(lan, lon)).body()?.photos?.photo)

    }
}