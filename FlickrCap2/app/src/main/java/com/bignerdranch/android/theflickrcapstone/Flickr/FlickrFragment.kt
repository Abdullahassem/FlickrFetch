package com.bignerdranch.android.theflickrcapstone.Flickr

import androidx.fragment.app.Fragment
import android.Manifest
import android.content.pm.PackageManager
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.LocationServices
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.theflickrcapstone.PhotosAdapter
import com.bignerdranch.android.theflickrcapstone.R


class FlickrFragment:Fragment() {
    private lateinit var photoRecyclerView: RecyclerView
    private lateinit var flickrViewModel: FlickrViewModel
    private var adapter: PhotosAdapter? = PhotosAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        flickrViewModel = ViewModelProvider(this)[FlickrViewModel::class.java]

        val view = inflater.inflate(R.layout.fragment_flickr, container, false)

        photoRecyclerView = view.findViewById(R.id.photo_recycler_view) as RecyclerView
        photoRecyclerView.layoutManager = GridLayoutManager(context, 3)
        photoRecyclerView.adapter = adapter

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                1
            )
        }

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if(location != null){
                flickrViewModel.getPhotos(location.latitude.toString(), location.longitude.toString())
                flickrViewModel.photosLiveData.observe(viewLifecycleOwner) { photosList ->

                    println(photosList.toString())
                    photoRecyclerView.adapter = PhotosAdapter(photosList)
                }
            }
        }




    }

}