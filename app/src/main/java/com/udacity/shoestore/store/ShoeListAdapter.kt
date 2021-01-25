package com.udacity.shoestore.store


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeListAdapter : ListAdapter<Shoe, ShoeListAdapter.ViewHolder>(ShoeListDiffCallback()) {

    lateinit var onItemClickListener: ShoeClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(onItemClickListener, item)
    }


    class ViewHolder constructor(val binding: ShoeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: ShoeClickListener, item: Shoe) {
            binding.shoe = item
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ShoeListItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class ShoeClickListener(val clickListener: (shoeId: String) -> Unit) {
    fun onClick(shoe: Shoe) = clickListener(shoe.shoeId)
}

class ShoeListDiffCallback : DiffUtil.ItemCallback<Shoe>() {

    override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem.shoeId == newItem.shoeId
    }

    override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe): Boolean {
        return oldItem == newItem
    }
}