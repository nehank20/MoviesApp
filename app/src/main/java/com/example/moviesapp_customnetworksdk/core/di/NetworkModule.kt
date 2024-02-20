package com.example.moviesapp_customnetworksdk.core.di

import android.app.Application
import android.content.Context
import com.example.moviesapp_customnetworksdk.core.util.InternetConnectivity
import com.example.moviesapp_customnetworksdk.core.util.InternetConnectivityImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providesContext(application: Application) : Context {
        return  application
    }

    @Singleton
    @Provides
    fun providesInternetConnectivity(context: Context) : InternetConnectivity {
        return InternetConnectivityImpl(context)
    }

}


