package com.davidmoreno.marvelapitest.common

import com.davidmoreno.marvelapitest.common.Util.getCorrectImageURL
import com.google.common.truth.Truth.assertThat


import org.junit.Test

class UtilTest {

    @Test
    fun getCorrectImageURLTest() {
        val imagePath = "http://i.annihil.us/u/prod/marvel/i/mg/8/04/58e69de9d1fed"
        val correctPath = "https://i.annihil.us/u/prod/marvel/i/mg/8/04/58e69de9d1fed.jpg"
        val imageExtension = "jpg"
        val result = getCorrectImageURL(imagePath, imageExtension)
        assertThat(result).containsMatch(correctPath)
    }

    @Test
    fun getIncorrectImageURLTest() {
        val imagePath = "http://i.annihil.us/u/prod/marvel/i/mg/8/04/58e69de9d1fed"
        val correctPath = "https://i.annihil.us/u/prod/marvel/i/mg/8/04/58e69de9d1fed.jpg"
        val imageExtension = ".jpg"
        val result = getCorrectImageURL(imagePath, imageExtension)
        assertThat(result).doesNotContainMatch(correctPath)
    }
}