package com.example.islami.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.databinding.QuranItemBinding
import com.example.islami.model.SuraNameIndex

class QuranAdapter(var suraList: List<SuraNameIndex>?) : Adapter<QuranAdapter.QuranViewHolder>() {
    var QuranClickListener: OnQuranClickListener? = null

    class QuranViewHolder(val binding: QuranItemBinding) : ViewHolder(binding.root) {
        fun bind(sura: SuraNameIndex) {
            binding.suraName.text = sura.name
            binding.suraNumber.text = "${sura.index}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = QuranItemBinding.inflate(layoutInflater, parent, false)
        return QuranViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return suraList?.size ?: 0
    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        val suraItem = suraList?.get(position) ?: return
        holder.bind(suraItem)
        holder.binding.root.setOnClickListener {
            QuranClickListener?.onQuranClick(sura = suraItem, position)
        }

    }

    interface OnQuranClickListener {
        fun onQuranClick(sura: SuraNameIndex, position: Int)
    }
}