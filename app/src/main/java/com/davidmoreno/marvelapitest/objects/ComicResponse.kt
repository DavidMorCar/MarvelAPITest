package com.davidmoreno.marvelapitest.objects

import com.google.gson.annotations.SerializedName

/** Response Object */
data class ComicResponse(
    @SerializedName("code")
    var code: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("copyright")
    var copyright: String,
    @SerializedName("data")
    var responseData: ResponseData
)
