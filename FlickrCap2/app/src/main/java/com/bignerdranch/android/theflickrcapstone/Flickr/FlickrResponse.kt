package com.bignerdranch.android.theflickrcapstone.Flickr

import com.bignerdranch.android.theflickrcapstone.Photos

data class FlickrResponse(
    val photos: Photos,
    val stat: String
)
