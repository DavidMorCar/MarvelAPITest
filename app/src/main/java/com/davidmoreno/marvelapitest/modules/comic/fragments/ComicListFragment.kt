package com.davidmoreno.marvelapitest.modules.comic.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidmoreno.marvelapitest.R
import com.davidmoreno.marvelapitest.common.BaseFragment
import com.davidmoreno.marvelapitest.common.DELAY
import com.davidmoreno.marvelapitest.common.Util.openURL
import com.davidmoreno.marvelapitest.modules.comic.adapters.ComicItemCallback
import com.davidmoreno.marvelapitest.modules.comic.adapters.ComicListAdapter
import com.davidmoreno.marvelapitest.modules.comic.viewmodels.ComicViewModel

/**
 * A simple [BaseFragment] subclass.
 * Use the [ComicListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ComicListFragment : BaseFragment() {

    /** ViewModel instance */
    private val viewModel: ComicViewModel by activityViewModels()

    /** View attributes */
    private lateinit var comicRV: RecyclerView
    private lateinit var comicView: View
    private lateinit var errorTV: TextView

    /** RecycleView and Adapter init */
    private var comicsAdapter: ComicListAdapter? = null
    private var itemListener: ComicItemCallback = object : ComicItemCallback {
        override fun itemClicked(position: Int) {
            viewModel.setComicPosition(position)
            showLoadingDialog()
            delayHandler.postDelayed({
                hideLoadingDialog()
                openComicDetails()
            }, DELAY)
        }
    }

    /** Fragment view creation */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comic_list, container, false)
    }

    /** Fragment instance */
    companion object {
        fun newInstance() = ComicListFragment()
    }

    /** API call if there is no data set */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.comicList.value == null) {
            viewModel.getComics(requireContext())
            showLoadingDialog()
        }
    }

    /** Observables implementation */
    override fun initObservers() {
        viewModel.comicList.observe(viewLifecycleOwner, Observer {
            hideLoadingDialog()
            if (!it.isNullOrEmpty()) {
                comicsAdapter = ComicListAdapter()
                comicsAdapter!!.setValues(requireContext(), it.toMutableList(), itemListener)
                comicRV.adapter = comicsAdapter
            } else {
                errorTV.visibility = View.VISIBLE
                comicRV.visibility = View.GONE
            }
        })
    }

    /** View init and assignation */
    override fun initViewComponents() {
        comicRV = requireActivity().findViewById(R.id.comicListRV)
        comicRV.layoutManager = (LinearLayoutManager(requireContext()))

        comicView = requireActivity().findViewById(R.id.comicListView)
        comicView.setOnClickListener {
            openURL("https://www.linkedin.com/in/david-moreno-533bb5155/", requireActivity())
        }
        errorTV = requireActivity().findViewById(R.id.comicErrorTV)
    }

    /** Open ComicDetailsFragment */
    private fun openComicDetails() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, ComicDetailsFragment.newInstance()).addToBackStack(null)
            .commit()
    }

}