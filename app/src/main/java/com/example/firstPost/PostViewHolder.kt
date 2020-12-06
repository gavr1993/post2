import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.firstPost.Post
import com.example.firstPost.PostType
import com.example.firstPost.R
import kotlinx.android.synthetic.main.post_item.view.*

class PostViewHolder
constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val author = itemView.authTv
    val repAuth = itemView.repost
    val date = itemView.dateTv
    val text = itemView.postTxt
    val likeBtn = itemView.likeBtn
    val likeNmb = itemView.likeNmb
    val comBtn = itemView.comBtn
    val comNmb = itemView.comNmb
    val shareBtn = itemView.shareBtn
    val shareNmb = itemView.shareNmb

    fun bind(post: Post) {
        author.text = post.author
        date.text = post.created
        text.text = post.content
        if (post.type = PostType.REPOST) {

        }

        likeBtn.setOnClickListener {
            post.likedByMe = !post.likedByMe
            if (post.likedByMe) {
                likeNmb.visibility = View.VISIBLE
                likeNmb.text = "1"
                likeNmb.setTextColor(Color.RED)
            } else {
                likeNmb.visibility = View.INVISIBLE
            }
            likeBtn.setImageResource(
                if (post.likedByMe) R.drawable.liked
                else R.drawable.not_liked
            )
        }

        comBtn.setOnClickListener {
            post.commentedByMe = !post.commentedByMe
            if (post.commentedByMe) {
                comNmb.visibility = View.VISIBLE
                comNmb.text = "1"
                comNmb.setTextColor(Color.RED)
            } else {
                comNmb.visibility = View.INVISIBLE
            }
            comBtn.setImageResource(
                if (post.commentedByMe) R.drawable.commented
                else R.drawable.not_commented
            )
        }

        shareBtn.setOnClickListener {
            post.sharedByMe = !post.sharedByMe
            if (post.sharedByMe) {
                shareNmb.visibility = View.VISIBLE
                shareNmb.text = "1"
                shareNmb.setTextColor(Color.RED)
            } else {
                shareNmb.visibility = View.INVISIBLE
            }
            shareBtn.setImageResource(
                if (post.sharedByMe) R.drawable.shared
                else R.drawable.not_shared
            )
        }
    }
}