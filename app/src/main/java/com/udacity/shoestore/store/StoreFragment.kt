package com.udacity.shoestore.store

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {

    private val viewModel: StoreViewModel by viewModels()

    private lateinit var binding: FragmentStoreBinding

    private lateinit var adapter: ShoeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        setHasOptionsMenu(true)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_store, container, false)

        // Setup Recycler View
        adapter = ShoeListAdapter()
        adapter.onItemClickListener = ShoeClickListener { shoeId ->
            findNavController().navigate(
                StoreFragmentDirections.actionStoreFragmentToDetailsFragment(shoeId)
            )
        }
        binding.shoeList.adapter = adapter

        // Fab
        binding.fabAddShoe.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(StoreFragmentDirections.actionStoreFragmentToEditorDialog())
        }

        // Data
        viewModel.shoeList.observe(viewLifecycleOwner, { shoeList ->
            adapter.submitList(shoeList)

            adapter.notifyDataSetChanged()
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_store, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_logout -> {
                findNavController().navigateUp()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}