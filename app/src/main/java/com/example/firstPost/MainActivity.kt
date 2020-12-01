package com.example.firstPost

import PostAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = listOf(
            Post(1, "Anton", "First post in our network!", "31 august 2020", "Uzhnaya street, 15"),
            Post(1, "Alex", "Second post in our network.", "11 november 2020", "Lenina street, 17"),
            Post(3, "Igor", "Wow!", "12 november 2020", "Central street, 17")
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