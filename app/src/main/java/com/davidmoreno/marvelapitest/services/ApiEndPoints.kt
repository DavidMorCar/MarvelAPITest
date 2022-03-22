package com.davidmoreno.marvelapitest.services

import com.davidmoreno.marvelapitest.objects.ComicResponse
import retrofit2.Response
import retrofit2.http.*

/**
 * API calls
 */
interface ApiEndPoints {

    /** Comics call */
    @GET("comics")
    suspend fun getComicsService(
        @Query(value = "orderBy") orderBy: String,
        @Query(value = "apikey") apikey: String,
        @Query(value = "hash") hash: String,
        @Query(value = "ts") ts: String
    ): Response<ComicResponse>

}