package com.udacity.shoestore.editor

import android.widget.ArrayAdapter
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.udacity.shoestore.R

@BindingAdapter("entries")
fun bindEntries(
        view: MaterialAutoCompleteTextView,
        entries: Array<String>
) {
    // custom binding adapter to convert "float" dimension to "int" offsets
    view.setAdapter(ArrayAdapter(view.context, R.layout.dropdown_item, entries))
}