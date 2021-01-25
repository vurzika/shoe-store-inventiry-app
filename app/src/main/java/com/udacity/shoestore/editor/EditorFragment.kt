package com.udacity.shoestore.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDialogEditBinding

class EditorFragment : DialogFragment() {

    private lateinit var binding: FragmentDialogEditBinding

    private val viewModel: EditorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // enable full-screen display
        setStyle(STYLE_NORMAL, R.style.AppTheme_NoActionBar)

        // disable existing dialog via back button
        isCancelable = false
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dialog_edit, container, false)

        binding.viewModel = viewModel

        // setup toolbar manually as fragment using own toolbar
        binding.toolbar.apply {
            // dismiss button
            setNavigationOnClickListener {
                showUnsavedChangesDialog()
            }

            // save button
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_save -> {
                        viewModel.save()
                        true
                    }
                    else -> false
                }
            }
        }

        viewModel.eventOnSaved.observe(viewLifecycleOwner, {
            findNavController().navigateUp()
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, { errorMessage ->
            errorMessage?.let {
                Snackbar.make(requireView(), errorMessage, Snackbar.LENGTH_LONG).show()
            }
        })

        return binding.root
    }

    private fun showUnsavedChangesDialog() {
        val builder = MaterialAlertDialogBuilder(requireContext())

        builder.apply {
            setMessage(R.string.dialog_discard_changes_message)

            setPositiveButton(R.string.dialog_discard_changes_button_discard) { _, _ ->
                findNavController().navigateUp()
            }

            setNegativeButton(R.string.dialog_discard_changes_button_keep_editing) { dialog, _ ->
                dialog?.dismiss()
            }
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}