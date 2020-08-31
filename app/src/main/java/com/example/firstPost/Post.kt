package com.example.firstPost

data class Post (
    val id: Int,
    val author: String,
    val content: String,
    val created: String,
    var likedByMe: Boolean = false,
    var commentedByMe: Boolean = false,
    var sharedByMe: Boolean = false
)
