package com.example.travelbuddy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.travelbuddy.databinding.ItemDestinationBinding

/**
 * Custom adapter that binds a list of [Destination] objects to the RecyclerView.
 *
 * @param destinations the items to show
 * @param onItemClick called with the tapped item, so the Activity decides what to do
 */
class DestinationAdapter(
    private val destinations: List<Destination>,
    private val onItemClick: (Destination) -> Unit
) : RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>() {

    /** Holds the views for one row, using ViewBinding instead of findViewById. */
    class DestinationViewHolder(
        val binding: ItemDestinationBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val binding = ItemDestinationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DestinationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        // Use the position of the row that was bound, so each row opens its own item
        val destination = destinations[position]
        val context = holder.itemView.context

        holder.binding.emojiText.text = destination.emoji
        holder.binding.nameText.text = destination.name
        holder.binding.countryText.text = destination.country
        holder.binding.taglineText.text = destination.tagline
        holder.binding.ratingText.text = context.getString(R.string.rating_format, destination.rating)

        holder.binding.root.setOnClickListener { onItemClick(destination) }
    }

    override fun getItemCount(): Int = destinations.size
}
