package com.udacity.shoestore.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.utils.Event

class OnBoardingViewModel : ViewModel() {

    val navigateToInstructions = MutableLiveData<Event<Unit>>()

    fun navigateToInstructions() {
        navigateToInstructions.value = Event(Unit)
    }

}
