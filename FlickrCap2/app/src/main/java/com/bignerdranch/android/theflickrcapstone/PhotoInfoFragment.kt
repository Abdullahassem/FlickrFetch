package com.bignerdranch.android.theflickrcapstone

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class PhotoInfoFragment :Fragment(R.layout.fragment_photo_info) {

    lateinit var photoImageView: ImageView
    lateinit var photoTitleTextView: TextView

    val arg by navArgs<PhotoDetailsFragmentArgs>()

    private val callback = OnMapReadyCallback { googleMap ->

        val sydney = LatLng(arg.photo.latitude.toDouble(), arg.photo.longitude.toDouble())
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 12f))
        googleMap.uiSettings.isZoomGesturesEnabled=true

    }

    override fun onViewCreated(view: View,savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoImageView = requireView().findViewById(R.id.photo_details_photo)
        photoTitleTextView = requireView().findViewById(R.id.photo_details_title)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

        Glide.with(photoImageView)
            .load(arg.photo.url_s)
            .into(photoImageView)

        photoTitleTextView.text = arg.photo.title


    }



}