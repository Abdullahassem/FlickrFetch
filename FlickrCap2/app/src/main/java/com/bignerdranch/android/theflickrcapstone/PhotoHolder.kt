package com.bignerdranch.android.theflickrcapstone

import android.view.View
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.theflickrcapstone.Flickr.FlickrFragmentDirections
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class PhotoHolder(view: View): RecyclerView.ViewHolder(view),View.OnClickListener{

    private val photoView: ImageView = view.findViewById(R.id.photo_view_holder)
    private lateinit var photo: Photo

    init { photoView.setOnClickListener(this) }

    fun bind(photo: Photo){
        this.photo = photo
        Glide.with(photoView)
            .load(photo.url_s)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(photoView)
    }

    override fun onClick(view: View?) {
        photoView.findNavController().navigate(FlickrFragmentDirections.actionFlickrFragmentToPhotoInfoFragment(photo))    }
}