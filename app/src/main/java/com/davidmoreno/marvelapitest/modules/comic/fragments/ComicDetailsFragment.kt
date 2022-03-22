package com.davidmoreno.marvelapitest.modules.comic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.davidmoreno.marvelapitest.R
import com.davidmoreno.marvelapitest.common.BaseFragment
import com.davidmoreno.marvelapitest.common.NO_DESCRIPTION_MESSAGE
import com.davidmoreno.marvelapitest.common.Util
import com.davidmoreno.marvelapitest.modules.comic.viewmodels.ComicViewModel
import com.squareup.picasso.Picasso

/**
 * A simple [BaseFragment] subclass.
 * Use the [ComicDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComicDetailsFragment : BaseFragment() {

    /** ViewModel instance */
    private val viewModel: ComicViewModel by activityViewModels()

    /** View attributes */
    private lateinit var comicIV: ImageView
    private lateinit var backIV: ImageView
    private lateinit var nameTV: TextView
    private lateinit var descriptionTV: TextView

    /** Fragment view creation */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comic_details, container, false)
    }

    /** Fragment instance */
    companion object {
        fun newInstance() = ComicDetailsFragment()
    }

    /** Observables implementation */
    override fun initObservers() {
    }

    /** View init and assignation */
    override fun initViewComponents() {
        val comic = viewModel.getSelectedComic()
        val url = Util.getCorrectImageURL(
            comic.image[0].path,
            comic.image[0].extension
        )
        comicIV = requireActivity().findViewById(R.id.comicIV)
        Picasso.get().load(url).into(comicIV)
        nameTV = requireActivity().findViewById(R.id.comicNameTV)
        nameTV.text = comic.title.trim()
        descriptionTV = requireActivity().findViewById(R.id.comicDescriptionTV)
        if (comic.description.isNullOrEmpty()) {
            descriptionTV.text = NO_DESCRIPTION_MESSAGE
        } else {
            descriptionTV.text = comic.description
        }
        backIV = requireActivity().findViewById(R.id.comicArrowIV)
        backIV.setOnClickListener() {
            requireActivity().supportFragmentManager.popBackStackImmediate()
        }
    }
}