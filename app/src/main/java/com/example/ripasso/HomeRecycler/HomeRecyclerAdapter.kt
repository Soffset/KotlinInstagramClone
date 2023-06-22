package com.example.ripasso.HomeRecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ripasso.HomeStoriesRecycler.StoriesRecyclerAdapter
import com.example.ripasso.R


class HomeRecyclerAdapter(private val mList: List<HomeRecyclerItem>, val context: Context) : RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
       val homeStoriesRecycler: RecyclerView? = itemView.findViewById(R.id.stories_recycler)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        return if (viewType == 0)
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

        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }


}