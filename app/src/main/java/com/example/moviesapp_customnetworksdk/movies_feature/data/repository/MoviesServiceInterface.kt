package com.example.moviesapp_customnetworksdk.movies_feature.data.repository

import com.example.moviesapp_customnetworksdk.movies_feature.data.model.response.MovieDetailResponse
import com.example.moviesapp_customnetworksdk.movies_feature.data.model.response.MovieListResponse
import com.nehank.networking.ApiResult
import kotlinx.coroutines.flow.Flow


interface MoviesServiceInterface {

    suspend fun getPopularMovies(endPoint : String) : Flow<ApiResult<MovieListResponse>>
    suspend fun getUpcomingMovies(endPoint : String) : Flow<ApiResult<MovieListResponse>>
    suspend fun getMovieDetail(movieID : Int, endPoint: String) : Flow<ApiResult<MovieDetailResponse>>

}