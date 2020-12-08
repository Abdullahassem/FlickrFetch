package com.bignerdranch.android.theflickrcapstone

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PhotosAdapter(var photos:List<Photo>):RecyclerView.Adapter<PhotoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder =
        PhotoHolder(LayoutInflater.from(parent.context).inflate(R.layout.photo_holder,parent,false))

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) { holder.bind(photos[position]) }

    override fun getItemCount(): Int =photos.size

}