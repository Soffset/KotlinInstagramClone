package com.example.ripasso.HomeRecycler

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ripasso.HomeStoriesRecycler.StoriesRecyclerAdapter
import com.example.ripasso.R

enum class RowType {
    HEADER,
    ROW
}

class HomeRecyclerAdapter(private val mList: List<HomeRecyclerItem>, private val context: Context) : RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
       val homeStoriesRecycler: RecyclerView? = itemView.findViewById(R.id.stories_recycler)

        val postImage : ImageView? = itemView.findViewById(R.id.post_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("HOME_RECYCLER_TYPE", viewType.toString())
        // inflates the card_view_design view
        // that is used to hold list item
        return if (viewType == RowType.HEADER.ordinal)
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_recycler_header, parent, false))
        else
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_recycler_post, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = mList[position]

        if ( position == 0 && currentItem.storyRecyclerData != null && holder.homeStoriesRecycler != null) {
            holder.homeStoriesRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            holder.homeStoriesRecycler.adapter = StoriesRecyclerAdapter(currentItem.storyRecyclerData, context)
        } else {
            if (holder.postImage != null)
                Glide.with(context).load(currentItem.postItem?.imageUrl).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(holder.postImage)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            RowType.HEADER.ordinal
        }else {
            RowType.ROW.ordinal
        }
    }


}