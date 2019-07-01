package com.codingblocks.networkingokhttpretrofit

data class GithubUser(
    val login: String,
    val avatar_url: String,
    val id: Int
)

data class Github(
//    val total_count: Int,
//    val incomplete_results: Boolean,
    val items: ArrayList<GithubUser>
)
