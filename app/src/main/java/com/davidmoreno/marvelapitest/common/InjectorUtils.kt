package com.davidmoreno.marvelapitest.common

import com.davidmoreno.marvelapitest.services.ApiEndPoints
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    /** ViewModel Factory provider */
    fun provideViewModelFactory(): ViewModelFactory {
        return ViewModelFactory()
    }

    /** API Services provider */
    fun provideApiService(): ApiEndPoints {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiEndPoints::class.java)
    }

}
