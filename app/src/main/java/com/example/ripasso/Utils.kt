package com.example.ripasso
import kotlin.math.floor


fun getRandomImageUrl(size: Int = 200): String {
    return "https://picsum.photos/seed/" + floor(Math.random() * 10000) + "/" + size.toString()
}