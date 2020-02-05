package com.udacity.shoestore.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.utils.Event

class LoginViewModel : ViewModel() {

    val navigateLiveEvent = MutableLiveData<Event<Unit>>()


    fun navigateToWelcomePage() {
        navigateLiveEvent.value = Event(Unit)
    }
}