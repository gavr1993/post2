package com.example.firstPost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.ktor.client.request.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(R.layout.activity_main), CoroutineScope by MainScope() {
    private lateinit var list: List<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchData()
        with(container) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = PostAdapter().apply {
                notifyItemRangeInserted(0, list.size)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

    fun fetchData() = launch {
        list = withContext(Dispatchers.IO) {
            Api.client.get<List<Post>>(Api.url)
        }
    }
}