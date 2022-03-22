package com.davidmoreno.marvelapitest.common

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment

/**
 * A [Fragment] subclass.
 */
abstract class BaseFragment : Fragment() {

    /** Delay handler */
    var delayHandler: Handler = Handler(Looper.getMainLooper())

    /** Show loading dialog */
    protected fun showLoadingDialog() {
        val prev = activity?.supportFragmentManager?.findFragmentByTag(LOADING_FRAGMENT_TAG)

        val newFragment: LoadingDialogFragment =
            if (prev == null || prev !is LoadingDialogFragment) {
                LoadingDialogFragment()
            } else
                prev

        if (!newFragment.isAdded) {
            newFragment.isCancelable = false
            newFragment.show(requireActivity().supportFragmentManager, LOADING_FRAGMENT_TAG)
        }
    }

    /** Hide loading dialog */
    protected fun hideLoadingDialog() {
        val prev = activity?.supportFragmentManager?.findFragmentByTag(LOADING_FRAGMENT_TAG)

        if (prev != null && prev is LoadingDialogFragment) {
            (prev).dismiss()
        }
    }

    /** Running abstract methods when view is created */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewComponents()
        initObservers()
    }

    abstract fun initViewComponents()

    abstract fun initObservers()
}