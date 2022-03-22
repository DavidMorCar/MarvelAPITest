package com.davidmoreno.marvelapitest.services

import com.davidmoreno.marvelapitest.common.*
import com.davidmoreno.marvelapitest.objects.ComicResponse

/**
 * API Service class with call methods
 */
class ComicApiService {
    private var apiServiceCall: ApiEndPoints = InjectorUtils.provideApiService()

    /** Comics call */
    suspend fun getComics(): ComicResponse? {
        val call = apiServiceCall.getComicsService(ORDER, PUBLIC_CREDENTIALS, HASH, TS)
        val response = call.body()
        return if (call.isSuccessful) {
            response
        } else {
            null
        }
    }
}