package com.udacity.shoestore.shoes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ShoeElementBinding
import com.udacity.shoestore.models.Shoe

class ShoesAdapter(
    private val list: List<Shoe>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<Shoe> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShoeElementBinding.inflate(LayoutInflater.from(parent.context), parent, false).root
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
}