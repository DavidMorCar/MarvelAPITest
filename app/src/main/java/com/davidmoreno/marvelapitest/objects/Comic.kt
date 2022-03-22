package com.davidmoreno.marvelapitest.objects

import com.google.gson.annotations.SerializedName

/** Comic Object */
data class Comic(
    @SerializedName("id")
    var id: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("issueNumber")
    var issueNumber: String,
    @SerializedName("images")
    var image: List<Image>,
    @SerializedName("description")
    var description: String,
    @SerializedName("pageCount")
    var pageCount: String
)
