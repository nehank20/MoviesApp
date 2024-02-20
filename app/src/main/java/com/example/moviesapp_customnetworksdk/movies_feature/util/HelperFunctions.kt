package com.example.moviesapp_customnetworksdk.movies_feature.util

import com.example.moviesapp_customnetworksdk.movies_feature.data.model.response.MovieDetailResponse


object HelperFunctions {

    fun listToString(list: List<MovieDetailResponse.Genre>?): String {
        return list?.mapNotNull { it.name }?.joinToString(", ") ?: ""
    }
}

