package com.codingblocks.networking

import com.google.gson.annotations.SerializedName

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