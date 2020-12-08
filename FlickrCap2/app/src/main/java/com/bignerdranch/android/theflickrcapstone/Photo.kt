package com.bignerdranch.android.theflickrcapstone
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
    val accuracy: String,
    val context: Int,
    val farm: Int,
    val geo_is_contact: Int,
    val geo_is_family: Int,
    val geo_is_friend: Int,
    val geo_is_public: Int,
    val height_s: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val latitude: String,
    val longitude: String,
    val owner: String,
    val place_id: String,
    val secret: String,
    val server: String,
    val title: String,
    val url_s: String,
    val width_s: Int,
    val woeid: String
) : Parcelable