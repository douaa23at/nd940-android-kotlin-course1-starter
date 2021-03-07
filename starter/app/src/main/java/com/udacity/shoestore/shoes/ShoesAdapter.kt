package com.udacity.shoestore.shoes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ShoeElementBinding
import com.udacity.shoestore.models.Shoe

class ShoesAdapter : RecyclerView.Adapter<ShoesAdapter.ShoeElementViewHolder>() {

    var items: List<Shoe> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeElementViewHolder {
        val shoeElementViewHolder =
            ShoeElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoeElementViewHolder(shoeElementViewHolder)
    }

    override fun onBindViewHolder(holder: ShoeElementViewHolder, i: Int) {
        holder.bind(
            ShoeElementViewHolder.Entity(
                name = items[i].name,
                size = items[i].size.toString(),
                company = items[i].company,
                description = items[i].description
            )
        )
    }

    override fun getItemCount() = items.size

    class ShoeElementViewHolder(
        private val binding: ShoeElementBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(entity: Entity) {
            binding.entity = entity
        }

        data class Entity(
            val name: String,
            val size: String,
            val company: String,
            val description: String,
            val images: List<String> = mutableListOf()
        )
    }


}