package com.example.islami.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.databinding.ItemVerseBinding

class VersesAdapter(var versesList: List<String>?) : Adapter<VersesAdapter.VersesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemVerseBinding.inflate(inflater, parent, false)
        return VersesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return versesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: VersesViewHolder, position: Int) {
        val item = versesList?.get(position) ?: return
        holder.bind(item)
    }

    fun updateData(verses: List<String>) {
        this.versesList = verses
        notifyDataSetChanged() // Reload - Refresh
    }

    class VersesViewHolder(val binding: ItemVerseBinding) : ViewHolder(binding.root) {
        fun bind(verse: String) {
            binding.suraVerseItem.text = verse
        }
    }


}
