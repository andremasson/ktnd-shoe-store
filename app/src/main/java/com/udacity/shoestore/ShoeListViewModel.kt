package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private val _shoeList : MutableLiveData<List<Shoe>> = MutableLiveData(
        listOf(
            Shoe("Runner", 42.5, "Adidas", "Just nice", mutableListOf("")),
            Shoe("Nike Air", 41.0, "Nike", "Very good", mutableListOf("")),
            Shoe("Casual", 39.5, "Rebook", "Very expensive", mutableListOf(""))
        )
    )

    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        //populateInitialData()
        Timber.i("Iniciando viewmodel")
    }

    private fun populateInitialData() {

        _shoeList.value = mutableListOf(
                Shoe("Runner", 42.5, "Adidas", "Just nice", mutableListOf("")),
                Shoe("Nike Air", 41.0, "Nike", "Very good", mutableListOf("")),
                Shoe("Casual", 39.5, "Rebook", "Very expensive", mutableListOf(""))
        )
    }

    fun addShoe(shoe: Shoe) {
        val newList: List<Shoe>? = _shoeList.value?.plus(shoe) as ArrayList<Shoe>
        _shoeList.value = newList
    }


}