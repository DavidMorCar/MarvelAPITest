package com.davidmoreno.marvelapitest.common

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.content.Intent
import android.net.Uri

/** Util methods */
object Util {

    /** Validate internet connection */
    @SuppressLint("MissingPermission")
    fun haveAnInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                //for check internet over Bluetooth
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
                else -> false
            }
        } else {
            return connectivityManager.activeNetworkInfo?.isConnected ?: false
        }
    }

    /** Method to get https url */
    fun getCorrectImageURL(path: String, extension: String): String {
        return "$path.$extension".replace("http://", "https://")
    }

    /** Method to open urls in browser */
    fun openURL(path: String, activity: Activity) {
        activity.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(path)
            )
        )
    }
}