package com.udacity.shoestore.shoes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel : ViewModel() {

    val shoesList = MutableLiveData<List<Shoe>>()

    fun initialize() {
        shoesList.value = listOf(
            Shoe("prada", 37.0, "prada", "", listOf("")),
            Shoe("gucci", 38.0, "gucci", "", listOf("")),
            Shoe("nike", 39.0, "nike", "", listOf(""))
        )
    }
}