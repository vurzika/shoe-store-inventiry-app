package com.udacity.shoestore.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DetailsViewModelFactory(private val shoeId: String) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(shoeId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}