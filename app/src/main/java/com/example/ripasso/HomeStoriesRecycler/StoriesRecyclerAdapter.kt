package com.example.ripasso.HomeStoriesRecycler

import android.content.Context
import android.content.res.AssetManager
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.ripasso.R
import java.io.InputStream


class StoriesRecyclerAdapter(private val mList: List<StoryItemViewModel>, val context: Context) : RecyclerView.Adapter<StoriesRecyclerAdapter.ViewHolder>() {
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
       val textView = itemView.findViewById<TextView>(R.id.story_text)
        val profilePictureView = itemView.findViewById<ImageView>(R.id.StoryUserProfilePicture)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.story_recycler_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = mList[position]

        holder.textView.text = currentItem.text

        if (currentItem.imageUrl?.isNotEmpty() == true )
            Glide.with(context).load(currentItem.imageUrl).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(holder.profilePictureView)
        else
            holder.profilePictureView.setImageResource(R.drawable.default_icon)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }


}