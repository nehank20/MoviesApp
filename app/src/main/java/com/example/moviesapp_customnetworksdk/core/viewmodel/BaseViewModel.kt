package com.example.moviesapp_customnetworksdk.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp_customnetworksdk.core.util.ErrorData
import dagger.hilt.android.lifecycle.HiltViewModel

open class BaseViewModel : ViewModel() {

    private val _errorMessages = MutableLiveData<ErrorData>()
    val errorMessages : LiveData<ErrorData> = _errorMessages


    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> = _loading


    private val _exception = MutableLiveData<String>()
    val exception : LiveData<String> = _exception


    protected fun handleError(
        errorCode: Int,
        errorMessage: String
    ){
        _errorMessages.postValue(ErrorData.Message(errorCode,errorMessage))
    }

    protected fun handleException(
        exceptionString : String
    ){
        _exception.postValue(exceptionString)
    }

    protected fun handleLoading(value: Boolean) {
        _loading.postValue(value)
    }
}