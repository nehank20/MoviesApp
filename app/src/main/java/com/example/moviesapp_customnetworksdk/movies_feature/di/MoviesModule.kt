package com.example.moviesapp_customnetworksdk.movies_feature.di

import com.example.moviesapp_customnetworksdk.core.util.InternetConnectivity
import com.example.moviesapp_customnetworksdk.movies_feature.data.repository.MoviesServiceInterface
import com.example.moviesapp_customnetworksdk.movies_feature.data.repository.MoviesServiceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object MoviesModule {


    @Provides
    fun provideMovieServiceRepository(
        internetConnectivity: InternetConnectivity
    ) : MoviesServiceInterface {
        return MoviesServiceRepository(internetConnectivity)
    }
}