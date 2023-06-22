package com.example.ripasso
import kotlin.math.floor


fun getRandomImageUrl(): String {
    return "https://picsum.photos/seed/" + floor(Math.random() * 10000) + "/200"
}