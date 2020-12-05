package com.bignerdranch.android.theflickrcapstone


import com.bignerdranch.android.photogallery.api.flickrResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {



    @GET(" https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=19a00727a5dbd578ecd3e4506e741fad&accuracy=&lat=0.0&lon=0.0&extras=url_s&format=json&nojsoncallback=1")
    suspend fun getPhotos(
        @Query("lat")lat:String,
        @Query("lon")lon:String
    ) : Response<flickrResponse>

}
