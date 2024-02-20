package com.example.moviesapp_customnetworksdk.core.util

sealed class ErrorData {
    class Code(val errorCode: Int) : ErrorData()
    class Message(val errorCode: Int, val errorMessage: String) : ErrorData()
}