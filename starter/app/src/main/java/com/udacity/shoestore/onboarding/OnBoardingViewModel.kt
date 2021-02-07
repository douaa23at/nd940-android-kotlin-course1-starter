package com.udacity.shoestore.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnBoardingViewModel : ViewModel() {

    val navigateToInstructions = MutableLiveData<Boolean>()

    fun navigateToInstructions() {
        navigateToInstructions.value = true
    }

}
