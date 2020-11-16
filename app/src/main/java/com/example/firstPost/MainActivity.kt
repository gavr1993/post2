package com.example.firstPost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.post_item.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_item)

        val list = mutableListOf(
            Post(1, "Anton", "First post in our network!", "31 august 2020", "Uzhnaya street, 15"),
            Post(1, "Alex", "Second post in our network.", "11 november 2020", "Lenina street, 17"),
            Post(3, "Igor", "Wow!", "12 november 2020", "Central street, 17")
        )

        list.forEach {
            val view = layoutInflater.inflate(R.layout.post_item, root, false).apply {
                postTxt.text = it.content
                dateTv.text = it.content
                authTv.text = it.content

            }
        }

        with(container) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostAdapter(list)

            val post = list[position]
            postTxt.text = post.content
            dateTv.text = post.created
            authTv.text = post.author
            val (lat, lon) = post.location

            likeBtn.setOnClickListener {
                post.likedByMe = !post.likedByMe
                if (post.likedByMe) {
                    likeNmb.visibility = android.view.View.VISIBLE
                    likeNmb.text = "1"
                    likeNmb.setTextColor(android.graphics.Color.RED)
                } else {
                    likeNmb.visibility = android.view.View.INVISIBLE
                }
                likeBtn.setImageResource(
                    if (post.likedByMe) com.example.firstPost.R.drawable.liked
                    else com.example.firstPost.R.drawable.not_liked
                )
            }

            locationBtn.setOnClickListener {
                val intent = android.content.Intent().apply {
                    action = android.content.Intent.ACTION_VIEW
                    data = android.net.Uri.parse("geo:$lat,$lon")
                }
                startActivity(intent)
            }

            if (post.likedByMe) {
                likeBtn.setImageResource(com.example.firstPost.R.drawable.liked)
                likeNmb.text = "1"
                likeNmb.setTextColor(android.graphics.Color.RED)
                likeNmb.visibility = android.view.View.VISIBLE
            }

            if (post.commentedByMe) {
                comImg.setImageResource(com.example.firstPost.R.drawable.commented)
                comNmb.text = "1"
                comNmb.setTextColor(android.graphics.Color.RED)
                comNmb.visibility = android.view.View.VISIBLE
            }

            if (post.sharedByMe) {
                shareImg.setImageResource(com.example.firstPost.R.drawable.shared)
                shareNmb.text = "1"
                shareNmb.setTextColor(android.graphics.Color.RED)
                shareNmb.visibility = android.view.View.VISIBLE
            }
        }
    }
}