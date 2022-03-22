package com.davidmoreno.marvelapitest.objects

import com.google.gson.annotations.SerializedName

/** Data Object */
data class ResponseData(
    @SerializedName("offset")
    var offset: String,
    @SerializedName("count")
    var count: String,
    @SerializedName("total")
    var total: String,
    @SerializedName("results")
    var comics: List<Comic>?
)