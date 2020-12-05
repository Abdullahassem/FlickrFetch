package com.bignerdranch.android.theflickrcapstone

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.flickr.com/services/rest/"

class FlickrRepository{

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FlickrApi::class.java)

    suspend fun getPhoto(lan: String, lon: String) = retrofit.getPhotos(lan, lon)// we need this method to work in the background
}
