
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstPost.Post
import com.example.firstPost.R
import kotlinx.android.synthetic.main.post_item.view.*
import java.util.*

class PostAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var list: List<Post> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostViewHolder -> {
                holder.bind(list[position])
            }
        }
    }
}

class PostViewHolder
constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val author = itemView.authTv
    val date = itemView.dateTv
    val text = itemView.postTxt

    fun bind(post: Post) {
        author.text = post.author
        date.text = post.created
        text.text = post.content

    }
}