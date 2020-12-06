package com.example.firstPost

data class Post(
    val id: Int,
    val author: String,
    val repostAuthor: String?,
    val content: String,
    val created: String,
    val address: String?,
    val location: Pair<Double, Double>? = 52.109212 to 26.055569,
    var likedByMe: Boolean = false,
    var commentedByMe: Boolean = false,
    var sharedByMe: Boolean = false,
    val link: String?,
    val type: PostType
)


