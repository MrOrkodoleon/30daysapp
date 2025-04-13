package com.example.a30daysapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager

class TheoryTopicAdapter(
    private val context: Context,
    private val dataset: List<TheoryTopic>
) : RecyclerView.Adapter<TheoryTopicAdapter.TheoryTopicViewHolder>() {

    class TheoryTopicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_title)
        val descriptionTextView: TextView = view.findViewById(R.id.item_description)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val cardView: androidx.cardview.widget.CardView = view as androidx.cardview.widget.CardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheoryTopicViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return TheoryTopicViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TheoryTopicViewHolder, position: Int) {
        val item = dataset[position]

        val title = if (item.titleResId == R.string.title_day_placeholder) {
            context.getString(item.titleResId, item.day)
        } else {
            context.getString(item.titleResId)
        }
        holder.titleTextView.text = title

        val description = if (item.descriptionResId == R.string.desc_day_placeholder) {
            context.getString(item.descriptionResId, item.day)
        } else {
            context.getString(item.descriptionResId)
        }
        holder.descriptionTextView.text = description

        holder.imageView.setImageResource(item.imageResId)
        holder.imageView.contentDescription = context.getString(R.string.topic_image_content_description)

        holder.itemView.setOnClickListener {
            val isVisible = holder.descriptionTextView.isVisible

            TransitionManager.beginDelayedTransition(holder.cardView, AutoTransition())

            holder.descriptionTextView.visibility = if (isVisible) View.GONE else View.VISIBLE
        }

        holder.descriptionTextView.visibility = View.GONE
    }
    override fun getItemCount() = dataset.size
}