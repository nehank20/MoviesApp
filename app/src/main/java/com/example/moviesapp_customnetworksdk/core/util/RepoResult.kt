package com.example.moviesapp_customnetworksdk.core.util

sealed class RepoResult<out T> {
    data class Success<out T>(val data : T) : RepoResult<T>()
    data class Error(val code: Int, val errorMessage: String) : RepoResult<Nothing>()
    data class Exception(val throwable: Throwable): RepoResult<Nothing>()
    data class Loading(val loadingStatus: Boolean): RepoResult<Nothing>()
}