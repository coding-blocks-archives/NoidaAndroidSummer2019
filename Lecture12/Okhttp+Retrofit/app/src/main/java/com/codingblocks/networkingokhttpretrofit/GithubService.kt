package com.codingblocks.networkingokhttpretrofit

import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("search/users?q=%22Pulkit%20Aggarwal%22")
    fun listUsers(): Call<GIthubResponse>

    @GET("search/users?q=%22Pulkit%20Aggarwal%22")
    fun listRepos(): Call<GIthubResponse>
}