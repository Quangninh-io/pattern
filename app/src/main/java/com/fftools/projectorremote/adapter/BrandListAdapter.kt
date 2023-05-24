package com.fftools.projectorremote.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.fftools.projectorremote.databinding.ItemBrandBinding
import com.fftools.projectorremote.model.ProjectorBrandEntity
import com.fftools.projectorremote.my_interface.BrandOnClickListener

class BrandListAdapter(private val context: Context): ListAdapter<ProjectorBrandEntity, BrandListAdapter.ItemBrandViewHolder>(
    BRAND_COMPARATOR) {
    private var brandOnClick: BrandOnClickListener? = null

    fun setListener(brandOnClick: BrandOnClickListener) {
        this.brandOnClick = brandOnClick
    }

    inner class ItemBrandViewHolder(itemView: ItemBrandBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        val binding: ItemBrandBinding

        init {
            binding = itemView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBrandViewHolder {
        return ItemBrandViewHolder(
            ItemBrandBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemBrandViewHolder, position: Int) {
        val brandItem = getItem(position)

        brandItem?.let {
            holder.binding.tvBrand.text = it.brand
        }
    }

    companion object {
        private val BRAND_COMPARATOR = object : DiffUtil.ItemCallback<ProjectorBrandEntity>() {
            override fun areItemsTheSame(oldItem: ProjectorBrandEntity, newItem: ProjectorBrandEntity): Boolean {
                return oldItem.brand == newItem.brand
            }

            override fun areContentsTheSame(oldItem: ProjectorBrandEntity, newItem: ProjectorBrandEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}