package com.udacity.shoestore.shoes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.utils.Event

class ShoesViewModel : ViewModel() {

    val navigateToDetailPage = MutableLiveData<Event<Unit>>()

    fun navigateToDetailPage() {
        navigateToDetailPage.value = Event(Unit)
    }
}