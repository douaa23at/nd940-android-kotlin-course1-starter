package com.udacity.shoestore.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val navigateLiveEvent = MutableLiveData<Boolean>()

    fun initialize() {
        navigateLiveEvent.value = false
    }

    fun navigateToWelcomePage() {
        navigateLiveEvent.value = true
    }
}