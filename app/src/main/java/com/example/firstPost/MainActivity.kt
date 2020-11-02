package com.example.firstPost

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val post = Post(
            1,
            "Anton",
            "First post in our network!",
            "31 august 2020",
            "Uzhnaya street, 15",
            likedByMe = true,
            commentedByMe = true,
            sharedByMe = true
        )

        postTxt.text = post.content
        dateTv.text = post.created
        authTv.text = post.author
        val (lat, lon) = post.location

        likeBtn.setOnClickListener {
            post.likedByMe = !post.likedByMe
            if (post.likedByMe) {
                likeNmb.visibility = VISIBLE
                likeNmb.text = "1"
                likeNmb.setTextColor(Color.RED)
            } else {
                likeNmb.visibility = INVISIBLE
            }
            likeBtn.setImageResource(
                if (post.likedByMe) R.drawable.liked
                else R.drawable.not_liked
            )
        }

        locationBtn.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("geo:$lat,$lon")
            }
            startActivity(intent)
        }

        if (post.likedByMe) {
            likeBtn.setImageResource(R.drawable.liked)
            likeNmb.text = "1"
            likeNmb.setTextColor(Color.RED)
            likeNmb.visibility = VISIBLE
        }

        if (post.commentedByMe) {
            comImg.setImageResource(R.drawable.commented)
            comNmb.text = "1"
            comNmb.setTextColor(Color.RED)
            comNmb.visibility = VISIBLE
        }

        if (post.sharedByMe) {
            shareImg.setImageResource(R.drawable.shared)
            shareNmb.text = "1"
            shareNmb.setTextColor(Color.RED)
            shareNmb.visibility = VISIBLE
        }
    }
}