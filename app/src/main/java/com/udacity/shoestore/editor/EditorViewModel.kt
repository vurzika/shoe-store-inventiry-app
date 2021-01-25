package com.udacity.shoestore.editor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesRepository
import java.util.*

// to get Application context we need to extend AndroidViewModel
class EditorViewModel(application: Application) : AndroidViewModel(application) {

    private val shoesRepository = ShoesRepository.instance

    // Fields displayed on screen

    var shoeName = ""
    var shoeCompany = ""
    var shoeDescription = ""
    var shoeSize = ""

    val availableShoeSizes: Array<String> =
            application.resources.getStringArray(R.array.sizes_array)

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?>
        get() = _errorMessage

    // Events

    private val _eventOnSaved = MutableLiveData<Boolean>()
    val eventOnSaved: LiveData<Boolean>
        get() = _eventOnSaved

    // Actions

    fun save() {
        if (shoeName.isBlank() || shoeSize.isBlank() || shoeCompany.isBlank() || shoeDescription.isBlank()) {
            _errorMessage.value =
                    getApplication<Application>().resources.getString(R.string.error_all_fields_must_be_filled_in)

        } else {
            val id = Date().time.toString()

            val newShoe = Shoe(id, shoeName, shoeSize, shoeCompany, shoeDescription)
            shoesRepository.addShoe(newShoe)

            _eventOnSaved.value = true
        }
    }
}