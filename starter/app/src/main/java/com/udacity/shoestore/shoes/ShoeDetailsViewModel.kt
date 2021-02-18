package com.udacity.shoestore.shoes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeDetailsViewModel : ViewModel() {

    val cancelShoesAdding = MutableLiveData<Unit>()
    val addShoeToListOfShoes = MutableLiveData<Unit>()

}