package com.example.moviesapp_customnetworksdk.custom_networking

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.net.HttpURLConnection
import java.net.URL
//
//class ApiNetLink {
//
//    suspend inline fun <reified T> execute(
//        url: String, apiKey: String,
//    ): Flow<ApiResult<T>> = flow {
//        var httpConnection: HttpURLConnection? = null
//        try {
//            val completeUrl = URL("$url?api_key=$apiKey")
//            httpConnection = completeUrl.openConnection() as HttpURLConnection
//
//            val code = httpConnection.responseCode
//            if (code != 200) {
//                throw IOException("Response from server : Error Code : $code")
//            }
//            val bufferedReader = BufferedReader(
//                InputStreamReader(httpConnection.inputStream)
//            )
//            val stringBuilder: StringBuilder = StringBuilder()
//            while (true) {
//                val readLine = bufferedReader.readLine() ?: break
//                stringBuilder.append(readLine)
//            }
//
//            val responseData = Gson().fromJson<T>(stringBuilder.toString(), typeToken<T>())
//            emit(ApiResult.Success(responseData))
//
//        } catch (exception: Exception) {
//            emit(ApiResult.Error(404, "Error in parsing data ${exception.localizedMessage}"))
//        } finally {
//            httpConnection?.disconnect()
//            emit(ApiResult.Error(500, "Something went wrong"))
//        }
//    }.flowOn(Dispatchers.IO)
//}
//
//
//inline fun <reified T> typeToken(): Type = object : TypeToken<T>() {}.type
//
//
