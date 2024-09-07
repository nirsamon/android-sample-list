package com.nino.samplelistapp

import android.annotation.SuppressLint
import android.graphics.Typeface.*
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nino.samplelistapp.databinding.ItemSampleListBinding

class SampleListAdapter : RecyclerView.Adapter<SampleListAdapter.ViewHolder>() {
    var items: List<Item> = listOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.toBinding())
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.count()

    data class Item(val name: String, val price: Double)

    inner class ViewHolder(val binding: ItemSampleListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, position: Int) {
            with(binding) {
                tvLabel.text = item.name
                tvPrice.text = "$ ${String.format("%.2f", item.price)}"

                if (position == itemCount - 1) {
                    tvLabel.setTypeface(null, BOLD)
                    tvPrice.setTypeface(null, BOLD)
                }
            }
        }
    }
}