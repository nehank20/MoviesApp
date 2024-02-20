package com.example.moviesapp_customnetworksdk.movies_feature.util.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.moviesapp_customnetworksdk.R

@BindingAdapter("loadImageUrl")
fun loadImageUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrBlank()) {
        Glide.with(view.context)
            .load("https://image.tmdb.org/t/p/w500$imageUrl")
            .placeholder(R.drawable.placeholder_image)
            .into(view)
    }
}