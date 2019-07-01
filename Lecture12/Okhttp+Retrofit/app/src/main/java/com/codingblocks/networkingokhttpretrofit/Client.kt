package com.codingblocks.networkingokhttpretrofit

import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Client {

    //OKhttp
    val okHttpClient = OkHttpClient()

    fun getUrl(url: String): Request {
        return Request.Builder()
            .url("https://api.github.com/$url")
            .build()
    }

//    fun okhttpCallback(fn: (Response?, Throwable?) -> Unit): Callback {
//        return object : Callback {
//            override fun onFailure(call: Call, e: IOException) = fn(null, e)
//
//            override fun onResponse(call: Call, response: Response) = fn(response, null)
//
//        }
//    }

//Retrofit

    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofitClient.create(GithubService::class.java)

    fun <T> retrofitCallBack(fn: (Response<T>?, Throwable?) -> Unit): Callback<T> {
        return object : Callback<T> {
            override fun onFailure(call: Call<T>?, e: Throwable) = fn(null, e)

            override fun onResponse(call: Call<T>?, response: Response<T>?) = fn(response, null)

        }
    }
}