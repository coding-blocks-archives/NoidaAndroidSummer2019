package com.codingblocks.networkingokhttpretrofit

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

object Client {
    val okHttpClient = OkHttpClient()

    fun getUrl(url: String): Request {
        return Request.Builder()
            .url("https://api.github.com/$url")
            .build()
    }

    fun okhttpCallback(fn: (Response?, Throwable?) -> Unit): Callback {
        return object : Callback {
            override fun onFailure(call: Call, e: IOException) = fn(null, e)

            override fun onResponse(call: Call, response: Response) = fn(response, null)

        }
    }
}