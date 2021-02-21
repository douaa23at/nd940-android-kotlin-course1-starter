package com.udacity.shoestore.shoes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailsEntity : ViewModel() {

    val cancelShoesAdding = MutableLiveData<Boolean>()
    val addShoeToListOfShoes = MutableLiveData<Shoe>()
    var entity = Shoe("", 0.0, "", "", emptyList())
    private lateinit var binding: FragmentShoeDetailsBinding

    fun init(bind: FragmentShoeDetailsBinding) {
        binding = bind
    }

    fun addShoeToListOfShoes(shoe: Shoe) {
        addShoeToListOfShoes.value = shoe
    }

    fun cancelShoesAdding(boolean: Boolean) {
        cancelShoesAdding.value = boolean
    }

    fun setShoeName(name: String) {
        entity.name = name
    }

    fun setShoeSize(size: Double) {
        entity.size = size
    }

    fun setCompanyName(company: String) {
        entity.company = company
    }

    fun setDescription(description: String) {
        entity.description = description
    }

}
