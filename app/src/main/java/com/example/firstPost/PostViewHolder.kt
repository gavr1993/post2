import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
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
    val locBtn = itemView.locationBtn
    val address = itemView.address
    val play = itemView.playBtn
    val link = itemView.linkBtn

    @SuppressLint("SetTextI18n")
    fun bind(post: Post) {
        author.text = post.author
        date.text = post.created
        text.text = post.content

        if (post.type == PostType.REPOST) {
            repAuth.visibility = View.VISIBLE
            repAuth.text = post.repostAuthor + " reposted:"
        } else {
            repAuth.visibility = View.INVISIBLE
        }
        if (post.type == PostType.EVENT) {
            address.visibility = View.VISIBLE
            address.text = post.address
            locBtn.visibility = View.VISIBLE
            locBtn.setOnClickListener {
                val (lat, lon) = post.location
                val intent = Intent().apply {
                    action = Intent.ACTION_VIEW
                    data = Uri.parse("geo:$lat,$lon")
                }
                it.context.startActivity(intent)
            }
        } else {
            address.visibility = View.INVISIBLE
            locBtn.visibility = View.INVISIBLE
        }

        if (post.type == PostType.VIDEO) {
            play.visibility = View.VISIBLE
            play.setOnClickListener {
                val browserIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/watch?v=yqxkr_c6QJw&t=326s")
                )
                it.context.startActivity(browserIntent)
            }
        } else {
            play.visibility = View.INVISIBLE
        }
        if (post.type == PostType.COMMERCIAL) {
            link.visibility = View.VISIBLE
            play.setOnClickListener {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://ram.by/"))
                it.context.startActivity(browserIntent)
            }
        } else {
            link.visibility = View.INVISIBLE
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