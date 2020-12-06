package com.example.firstPost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = listOf(
            Post(
                1, "Anton", null, "First post in our network!",
                "31 august 2020", null,
                likedByMe = false, commentedByMe = false, sharedByMe = false, location = null,
                link = null, type = PostType.POST
            ),
            Post(
                2, "Anton", "Alex", "First post in our network!",
                "31 august 2020", null,
                likedByMe = false, commentedByMe = false, sharedByMe = false, location = null,
                link = null, type = PostType.REPOST
            ),
            Post(
                3,
                "Igor",
                null,
                "Welcome to my concert!",
                "01 september 2020",
                "Pervomayskaya street, 140",
                likedByMe = false,
                commentedByMe = false,
                sharedByMe = false,
                location = 52.13588989227583 to 26.10130046994913,
                link = null,
                type = PostType.EVENT
            ),
            Post(
                4, "Inna", null, "Look!",
                "02 september 2020", null, null,
                likedByMe = false, commentedByMe = false, sharedByMe = false,
                link = "https://www.youtube.com/watch?v=yqxkr_c6QJw", type = PostType.VIDEO
            ),
            Post(
                5, "RAM.BY", null, "Everything for PC!",
                "03 september 2020", null, null,
                likedByMe = false, commentedByMe = false, sharedByMe = false,
                link = "https://ram.by/", type = PostType.COMMERCIAL
            )
        )

        with(container) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostAdapter().apply {
                this.list = list
                notifyItemRangeInserted(0, list.size)
            }
        }
    }
}