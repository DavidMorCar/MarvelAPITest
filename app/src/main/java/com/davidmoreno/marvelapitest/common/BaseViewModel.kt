package com.davidmoreno.marvelapitest.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

/**
 * A [ViewModel] subclass.
 */
abstract class BaseViewModel : ViewModel() {

    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = SupervisorJob()

    /**
     * This is the main scope for all coroutines launched by LoginViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines
     * launched by uiScope by calling viewModelJob.cancel()
     * IO = input/output, Main = main thread, Default = large loading
     */
    val ioScope = CoroutineScope(Dispatchers.IO + viewModelJob)
    val mainScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    val defaultScope = CoroutineScope(Dispatchers.Default + viewModelJob)

    /**
     * Cancel all coroutines when the ViewModel is cleared
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}