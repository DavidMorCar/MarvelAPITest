package com.davidmoreno.marvelapitest.repositories

import android.content.Context
import com.davidmoreno.marvelapitest.services.ComicApiService
import com.davidmoreno.marvelapitest.common.Util
import com.davidmoreno.marvelapitest.objects.ComicResponse

/** Comic calls repository */
class ComicRepository {
    /** API Service init */
    private val comicApiService: ComicApiService = ComicApiService()

    /** Comics call */
    suspend fun getComics(context: Context): ComicResponse? {
        if (!Util.haveAnInternetConnection(context))
            return null
        return comicApiService.getComics()
    }

    companion object {
        /** For Singleton instantiation */
        @Volatile
        private var instance: ComicRepository? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: ComicRepository().also { instance = it }
            }
    }
}
