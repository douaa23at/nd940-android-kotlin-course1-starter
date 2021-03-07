package com.udacity.shoestore.shoes

import android.app.Application
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.utils.Event
import com.udacity.shoestore.utils.ObservableViewModel

class ShoeDetailsEntity(application: Application) : ObservableViewModel(application) {

    val cancelShoesAdding = MutableLiveData<Event<Unit>>()
    val addShoeToListOfShoes = MutableLiveData<Event<Shoe>>()

    fun addShoeToListOfShoes() {
        addShoeToListOfShoes.value =
            Event(Shoe(name, shoeSize.toDouble(), company, description))
    }

    fun cancelShoesAdding() {
        cancelShoesAdding.value = Event(Unit)
    }

    @Bindable
    var name = ""
        set(value) {
            field = value
            notifyChange(BR.name)
            notifyChange(BR.enabled)

        }

    @Bindable
    var shoeSize = ""
        set(value) {
            field = value
            notifyChange(BR.shoeSize)
            notifyChange(BR.enabled)
        }


    @Bindable
    var company = ""
        set(value) {
            field = value
            notifyChange(BR.company)
            notifyChange(BR.enabled)
        }

    @Bindable
    var description = ""
        set(value) {
            field = value
            notifyChange(BR.description)
            notifyChange(BR.enabled)
        }

    @get:Bindable
    val enabled: Boolean
        get() {
            return (name.isNotBlank() && shoeSize.isNotBlank() && company.isNotBlank() && description.isNotBlank())
        }

}
