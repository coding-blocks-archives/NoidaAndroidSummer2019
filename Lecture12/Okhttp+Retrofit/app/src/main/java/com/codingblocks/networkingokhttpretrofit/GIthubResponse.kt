package com.codingblocks.networkingokhttpretrofit

import com.google.gson.annotations.SerializedName

data class GIthubResponse(

    @field:SerializedName("total_count")
    val totalCount: Int? = null,

    @field:SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,

    @field:SerializedName("items")
    val items: List<ItemsItem?>? = null
)