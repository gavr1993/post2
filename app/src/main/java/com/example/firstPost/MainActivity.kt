package com.example.firstPost
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import io.ktor.client.request.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
class MainActivity : AppCompatActivity(R.layout.activity_main), CoroutineScope by MainScope() {
    private val adapter = PostAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchData()
        container.layoutManager = LinearLayoutManager(this)
        container.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }

    private fun fetchData() = launch {
        val list = Api.client.get<List<Post>>(Api.url)
        adapter.list = list
        adapter.notifyItemRangeInserted(0, list.size)
    }
}