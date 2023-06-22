package com.example.ripasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.ripasso.HomeRecycler.HomeRecyclerAdapter
import com.example.ripasso.HomeRecycler.HomeRecyclerItem
import com.example.ripasso.HomeRecycler.PostItem
import com.example.ripasso.HomeStoriesRecycler.StoriesRecyclerAdapter
import com.example.ripasso.HomeStoriesRecycler.StoryItemViewModel
import com.example.ripasso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val storiesData = listOf(
            StoryItemViewModel("Mario", getRandomImageUrl()),
            StoryItemViewModel("Franc1"),
            StoryItemViewModel("ksyai", getRandomImageUrl()),
            StoryItemViewModel("jaisu", getRandomImageUrl()),
            StoryItemViewModel("lopi12", getRandomImageUrl()),
            StoryItemViewModel("guasz", getRandomImageUrl()),
            StoryItemViewModel("ggigi", getRandomImageUrl()),
            StoryItemViewModel("Serio"),
        )

        val postsData = listOf(
            PostItem(getRandomImageUrl()),
            PostItem(getRandomImageUrl()),
            PostItem(getRandomImageUrl()),
            PostItem(getRandomImageUrl()),
            PostItem(getRandomImageUrl()),
        )

        val homeRecycler = binding.homeRecycler
        homeRecycler.layoutManager = LinearLayoutManager(this)

        val homeData = listOf(
            HomeRecyclerItem(storiesData),
        )

        // Setting the Adapter with the recyclerview
        homeRecycler.adapter = HomeRecyclerAdapter(homeData, this)
    }
}