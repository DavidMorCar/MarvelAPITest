package com.davidmoreno.marvelapitest.modules.comic


import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.davidmoreno.marvelapitest.R
import com.davidmoreno.marvelapitest.common.DELAY
import com.davidmoreno.marvelapitest.common.BaseActivity
import com.davidmoreno.marvelapitest.common.InjectorUtils
import com.davidmoreno.marvelapitest.modules.comic.fragments.ComicListFragment
import com.davidmoreno.marvelapitest.modules.comic.viewmodels.ComicViewModel

/**
 * A [BaseActivity] subclass.
 */
class ComicActivity : BaseActivity() {

    /** onCreate with Splash implementation */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            delayHandler.postDelayed({
            }, DELAY)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ComicListFragment.newInstance())
                .commitNow()
        }
        setContentView(R.layout.activity_main)
    }

    private val viewModel: ComicViewModel by viewModels {
        InjectorUtils.provideViewModelFactory()
    }
}