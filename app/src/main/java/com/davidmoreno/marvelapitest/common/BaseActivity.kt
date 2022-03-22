package com.davidmoreno.marvelapitest.common

import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

/**
 * A [AppCompatActivity] subclass.
 */
abstract class BaseActivity : AppCompatActivity() {

    /** Delay handler */
    var delayHandler: Handler = Handler(Looper.getMainLooper())

}