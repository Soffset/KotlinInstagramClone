package com.example.ripasso.HomeRecycler

import com.example.ripasso.HomeStoriesRecycler.StoryItem

data class PostItem(val imageUrl: String? = null)

data class HomeRecyclerItem(val storyRecyclerData: List<StoryItem>? = null, val postItem: PostItem? = null)