package com.example.moviesapp_customnetworksdk.movies_feature.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesapp_customnetworksdk.core.viewmodel.BaseViewModel
import com.example.moviesapp_customnetworksdk.movies_feature.data.model.response.MovieDetailResponse
import com.example.moviesapp_customnetworksdk.movies_feature.data.model.response.MovieListResponse
import com.example.moviesapp_customnetworksdk.movies_feature.data.repository.MoviesServiceInterface
import com.nehank.networking.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val moviesServiceInterface: MoviesServiceInterface
) : BaseViewModel() {

    private val _upcomingMovies = MutableLiveData<MovieListResponse>()
    var upcomingMovies : LiveData<MovieListResponse> = _upcomingMovies

    private val _popularMovies = MutableLiveData<MovieListResponse>()
    var popularMovies : LiveData<MovieListResponse> = _popularMovies

    private val _movieDetail = MutableLiveData<MovieDetailResponse>()
    var movieDetail : LiveData<MovieDetailResponse> = _movieDetail


    fun getUpcomingMovies() {
        viewModelScope.launch {
            moviesServiceInterface.getUpcomingMovies("movie/upcoming").collect {
                when(it){
                    is ApiResult.Loading -> {
                        handleLoading(it.loadingStatus)
                    }
                    is ApiResult.Success -> {
                        it.data.let { movieListResponse ->
                            _upcomingMovies.postValue(movieListResponse)
                        }
                    }
                    is ApiResult.Error -> {
                        handleError(it.code, it.errorMessage)
                    }
                    is ApiResult.Exception -> {
                        handleException(it.throwable.localizedMessage ?: "Something went wrong")
                    }
                }
            }
        }
    }

    fun getPopularMovies() {
        viewModelScope.launch {
            moviesServiceInterface.getPopularMovies("movie/popular").collect {
                when(it){
                    is ApiResult.Loading -> {
                        handleLoading(it.loadingStatus)
                    }
                    is ApiResult.Success -> {
                        it.data.let { movieListResponse ->
                            _popularMovies.postValue(movieListResponse)
                        }
                    }
                    is ApiResult.Error -> {
                        handleError(it.code, it.errorMessage)
                    }
                    is ApiResult.Exception -> {
                        handleException(it.throwable.localizedMessage ?: "Something went wrong")
                    }
                }
            }
        }
    }

    fun getMovieDetail(movieID : String) {
        viewModelScope.launch {
            moviesServiceInterface.getMovieDetail(movieID = movieID.toInt(), endPoint = "movie/").collect {
                when(it){
                    is ApiResult.Loading -> {
                        handleLoading(it.loadingStatus)
                    }
                    is ApiResult.Success -> {
                        it.data.let { movieDetailResponse ->
                            _movieDetail.postValue(movieDetailResponse)
                        }
                    }
                    is ApiResult.Error -> {
                        handleError(it.code, it.errorMessage)
                    }
                    is ApiResult.Exception -> {
                        handleException(it.throwable.localizedMessage ?: "Something went wrong")
                    }
                }
            }
        }
    }
}