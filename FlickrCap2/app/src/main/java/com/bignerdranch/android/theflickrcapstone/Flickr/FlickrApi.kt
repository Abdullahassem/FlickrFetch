package com.bignerdranch.android.theflickrcapstone.Flickr


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {



    @GET("?method=flickr.photos.search" +
            "&api_key=4f721bbafa75bf6d2cb5af54f937bb70" +
            "&accuracy=1" +
            "&extras=url_s%2Cgeo%2Cdate_taken%2Cowner_name%2Curl_o" +
            "&format=json" +
            "&radius_units=km"+
            "&nojsoncallback=1")
    suspend fun getPhotos(
        @Query("lat")lat:String,
        @Query("lon")lon:String
    ) : Response<FlickrResponse>

}
