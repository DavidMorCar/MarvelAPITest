package com.davidmoreno.marvelapitest.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.davidmoreno.marvelapitest.modules.comic.viewmodels.ComicViewModel

/** ViewModel Provider Factory Global Instance */
class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass.newInstance()) {
            is ComicViewModel -> modelClass.cast(ComicViewModel()) as T

            else -> modelClass.cast(ComicViewModel()) as T
        }
    }
}




