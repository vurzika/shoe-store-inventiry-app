package com.udacity.shoestore.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesRepository

class DetailsViewModel(shoeId: String) : ViewModel() {

    private val shoesRepository = ShoesRepository.instance

    val shoeDetails: LiveData<Shoe> by lazy {
        shoesRepository.getShoe(shoeId)
    }
}