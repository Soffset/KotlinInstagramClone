package com.example.ripasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ripasso.HomeRecycler.HomeRecyclerAdapter
import com.example.ripasso.HomeRecycler.HomeRecyclerItem
import com.example.ripasso.HomeRecycler.PostItem
import com.example.ripasso.HomeStoriesRecycler.StoryItem
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
            StoryItem("Mario", getRandomImageUrl()),
            StoryItem("Franc1"),
            StoryItem("ksyai", getRandomImageUrl()),
            StoryItem("jaisu", getRandomImageUrl()),
            StoryItem("lopi12", getRandomImageUrl()),
            StoryItem("guasz", getRandomImageUrl()),
            StoryItem("ggigi", getRandomImageUrl()),
            StoryItem("Serio"),
        )

        val homeRecycler = binding.homeRecycler
        homeRecycler.layoutManager = LinearLayoutManager(this)

        val homeData = listOf(
            HomeRecyclerItem(storiesData),
            HomeRecyclerItem(postItem = PostItem(getRandomImageUrl(2000))),
            HomeRecyclerItem(postItem = PostItem(getRandomImageUrl(2000))),
            HomeRecyclerItem(postItem = PostItem(getRandomImageUrl(2000))),
            HomeRecyclerItem(postItem = PostItem(getRandomImageUrl(2000))),
            HomeRecyclerItem(postItem = PostItem(getRandomImageUrl(2000))),

        )

        // Setting the Adapter with the recyclerview
        homeRecycler.adapter = HomeRecyclerAdapter(homeData, this)
    }
}