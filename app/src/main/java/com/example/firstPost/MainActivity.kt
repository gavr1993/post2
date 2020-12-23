package com.example.firstPost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list =
            with(container) {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = PostAdapter().apply {
                    this.list = list
                    notifyItemRangeInserted(0, list.size)
                }
            }
    }
}