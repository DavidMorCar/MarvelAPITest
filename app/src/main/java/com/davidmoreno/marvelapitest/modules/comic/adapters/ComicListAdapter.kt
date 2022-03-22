package com.davidmoreno.marvelapitest.modules.comic.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.davidmoreno.marvelapitest.R
import com.davidmoreno.marvelapitest.common.Util.getCorrectImageURL
import com.davidmoreno.marvelapitest.objects.Comic
import com.squareup.picasso.Picasso

/**
 * A simple [RecyclerView.Adapter] subclass.
 */
class ComicListAdapter : RecyclerView.Adapter<ComicListAdapter.ViewHolder>() {

    /** View and array variables */
    var comics: MutableList<Comic>? = null
    private var size = 0
    private var context: Context? = null
    private var itemClickListener: ComicItemCallback? = null

    /** Set array and view parameters, update data set */
    fun setValues(
        applicationContext: Context?, newEvents: List<Comic>?,
        listener: ComicItemCallback
    ) {
        context = applicationContext
        itemClickListener = listener
        comics = newEvents?.toMutableList()
        size = comics?.size ?: 0
        notifyDataSetChanged()
    }

    /** View Holder Creation */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comic, parent, false)

        return ViewHolder(view)
    }

    /** View Bind */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTV.text = (comics?.get(position)?.title)
        holder.nameTV.text.trim()
        val url = getCorrectImageURL(
            comics!![position].image[0].path,
            comics!![position].image[0].extension
        )
        Picasso.get().load(url).into(holder.imageView)
        holder.view.setOnClickListener() {
            itemClickListener?.itemClicked(position)
        }
    }

    /** Items count */
    override fun getItemCount(): Int {
        return size
    }

    /**
     * A simple [RecyclerView.ViewHolder] subclass.
     */
    class ViewHolder internal constructor(mView: View) : RecyclerView.ViewHolder(
        mView
    ) {
        val view: View = mView
        val nameTV: TextView = mView.findViewById(R.id.itemComicNameTV)
        val imageView: ImageView = mView.findViewById(R.id.itemComicIV)
    }
}