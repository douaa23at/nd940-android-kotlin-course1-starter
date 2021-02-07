package com.udacity.shoestore.shoes

import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ShoeElementBinding

class ShoeElementViewHolder(
    private val binding: ShoeElementBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(entity: Entity) {
        binding.entity = entity
    }

    data class Entity(
        val name: String,
        val size: Double,
        val company: String,
        val description: String,
        val images: List<String> = mutableListOf()
    )
}