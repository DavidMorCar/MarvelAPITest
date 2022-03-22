package com.davidmoreno.marvelapitest.objects

import com.google.gson.annotations.SerializedName

/** Image Object */
data class Image(
    @SerializedName("path")
    var path: String,
    @SerializedName("extension")
    var extension: String,
)
