package com.azuka.networkcache.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azuka.networkcache.R
import com.azuka.networkcache.domain.model.Post
import kotlinx.android.synthetic.main.item_post.view.*


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

class PostAdapter(private val postList: List<Post>) :
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    private var expandedItemPosition = -1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(post: Post) {
            itemView.apply {
                if (post.isExpanded) llSubItem.visibility = View.VISIBLE
                else llSubItem.visibility = View.GONE

                tvTitle.text = post.title
                tvBody.text = post.body
            }
        }
    }

    override fun getItemCount(): Int = postList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = postList[position]
        holder.bind(post)

        holder.itemView.llItem.setOnClickListener {
            if (expandedItemPosition >= 0 && expandedItemPosition != position) {
                val previousExpandedItemPosition = expandedItemPosition
                val previousExpandedItem = postList[previousExpandedItemPosition]
                previousExpandedItem.isExpanded = false
                notifyItemChanged(previousExpandedItemPosition)
            }
            expandedItemPosition = position
            val isExpanded = post.isExpanded
            post.isExpanded = !isExpanded
            notifyItemChanged(position)
        }
    }
}