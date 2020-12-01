import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.firstPost.Post
import kotlinx.android.synthetic.main.post_item.view.*

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