package com.udacity.shoestore.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainActivityViewModel : ViewModel() {

    var listOfShoes = MutableLiveData<List<Shoe>>()

    val shoes = mutableListOf(
        Shoe("prada", 37.0, "prada", "boots"),
        Shoe("gucci", 38.0, "gucci", "wedges"),
        Shoe("nike", 39.0, "nike", "sneakers")
    )

    fun initialize() {
        listOfShoes.value = shoes
    }

    fun addShoe(shoe: Shoe) {
        shoes.add(shoe)
        listOfShoes.value = shoes
    }
}
