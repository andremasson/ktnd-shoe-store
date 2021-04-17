package com.udacity.shoestore

import androidx.databinding.adapters.Converters
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetailViewModel : ViewModel() {

    private val _eventSave = MutableLiveData<Boolean>()
    val eventSave: LiveData<Boolean>
        get() = _eventSave

    public lateinit var shoe: Shoe

    var name: String = ""
    var size: String = ""
    var company: String = ""
    var description: String = ""

    fun returnShoe(): Shoe {
        if (size.isNullOrBlank()) {
            size = "0.0";
        }
        return Shoe(
                name,
                size.toDouble(),
                company,
                description,
                ArrayList<String>()
        )
    }
}