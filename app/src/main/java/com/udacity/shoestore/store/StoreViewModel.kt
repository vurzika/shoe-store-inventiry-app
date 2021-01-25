package com.udacity.shoestore.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesRepository

class StoreViewModel : ViewModel() {

    private val shoesRepository = ShoesRepository.instance

    val shoeList: LiveData<List<Shoe>> by lazy {
        shoesRepository.getShoesList()
    }
}