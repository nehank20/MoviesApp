package com.example.moviesapp_customnetworksdk.core.data.networking

import com.nehank.networking.ApiResult
import com.nehank.networking.api_netlink.ApiNetLink
import kotlinx.coroutines.flow.Flow


abstract class ApiNetLinkImpl {

    suspend inline fun <reified T> execute(
        url: String,
        apiKey: String
    ): Flow<ApiResult<T>> {

        val customNetworkLibrary = ApiNetLink()
        return customNetworkLibrary.execute(
            url,
            apiKey,
        )
    }
}
