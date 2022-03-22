package com.davidmoreno.marvelapitest.modules.comic.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.davidmoreno.marvelapitest.common.BaseViewModel
import com.davidmoreno.marvelapitest.objects.Comic
import com.davidmoreno.marvelapitest.repositories.ComicRepository
import kotlinx.coroutines.launch

/**
 * A [BaseViewModel] subclass.
 */
class ComicViewModel : BaseViewModel() {

    /** Repository init */
    private val repository = ComicRepository.getInstance()

    /** Observable live data */
    val comicList = MutableLiveData<List<Comic>?>()
    val comicPosition = MutableLiveData<Int>()

    /** ViewModel init */
    init {
        viewModelScope.launch {
            // Coroutine that will be canceled when the ViewModel is cleared.
            // Use when viewModel init with a routine
        }
    }

    /** Position setter */
    fun setComicPosition(position: Int) {
        comicPosition.value = position
    }

    /** Selected Comic getter */
    fun getSelectedComic(): Comic {
        return comicPosition.value?.let { comicList.value!!?.get(it) }!!
    }

    /** Comics API call */
    fun getComics(context: Context) {
        ioScope.launch {
            val comicsResponse = repository.getComics(context)
            if (comicsResponse != null) {
                comicList.postValue(comicsResponse.responseData.comics)
            } else {
                comicList.postValue(null)
            }
        }
    }

}