package com.example.moviesapp_customnetworksdk.movies_feature.data.repository

import com.example.moviesapp_customnetworksdk.core.util.Constant.API_KEY
import com.example.moviesapp_customnetworksdk.core.util.Constant.BASE_URL
import com.example.moviesapp_customnetworksdk.core.util.InternetConnectivity
import com.example.moviesapp_customnetworksdk.core.data.networking.ApiNetLinkImpl
import com.example.moviesapp_customnetworksdk.movies_feature.data.model.response.MovieDetailResponse
import com.example.moviesapp_customnetworksdk.movies_feature.data.model.response.MovieListResponse
import com.nehank.networking.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesServiceRepository @Inject constructor(
    private val internetConnectivity: InternetConnectivity
)  : MoviesServiceInterface, ApiNetLinkImpl() {


    override suspend fun getPopularMovies(endPoint : String): Flow<ApiResult<MovieListResponse>> {
        return if (internetConnectivity.isNetworkAvailable()) {
            execute(
                url = "$BASE_URL$endPoint",
                apiKey = API_KEY,
            )
        } else {
            flow {
                emit(ApiResult.Error(404, "No internet"))
            }
        }
    }

    override suspend fun getUpcomingMovies(endPoint : String): Flow<ApiResult<MovieListResponse>> {
        return if (internetConnectivity.isNetworkAvailable()) {
            execute(
                url = "$BASE_URL$endPoint",
                apiKey = API_KEY
            )
        } else {
            flow {
                emit(ApiResult.Error(404, "No internet"))
            }
        }
    }

    override suspend fun getMovieDetail(movieID: Int, endPoint: String): Flow<ApiResult<MovieDetailResponse>> {
        return if (internetConnectivity.isNetworkAvailable()) {
            execute(
                url = "$BASE_URL$endPoint$movieID",
                apiKey = API_KEY
            )
        } else {
            flow {
                emit(ApiResult.Error(404, "No internet"))
            }
        }
    }
}