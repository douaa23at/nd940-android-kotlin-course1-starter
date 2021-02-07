package com.udacity.shoestore.instruction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionViewModel : ViewModel() {

    val navigateToShoesList = MutableLiveData<Boolean>()

    fun navigateToShoesList() {
        navigateToShoesList.value = true
    }

}