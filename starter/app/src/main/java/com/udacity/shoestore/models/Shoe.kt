package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Shoe(var name: String, var size: Double, var company: String, var description: String) :
    Parcelable