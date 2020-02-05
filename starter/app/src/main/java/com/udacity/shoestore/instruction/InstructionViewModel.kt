package com.udacity.shoestore.instruction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.utils.Event

class InstructionViewModel : ViewModel() {

    val navigateToShoesList = MutableLiveData<Event<Unit>>()

    fun navigateToShoesList() {
        navigateToShoesList.value = Event(Unit)
    }
}
