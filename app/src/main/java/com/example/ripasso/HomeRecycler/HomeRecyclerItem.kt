package com.example.ripasso.HomeRecycler

import com.example.ripasso.HomeStoriesRecycler.StoryItemViewModel

data class PostItem(val imageUrl: String? = null) {
}

data class HomeRecyclerItem(val storyRecyclerData: List<StoryItemViewModel>? = null, val postsData: List<PostItem>? = null) {
}