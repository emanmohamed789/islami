package com.example.islami.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islami.databinding.HadithItemBinding

class HadithAdapter(var hadithList: List<String>?) : Adapter<HadithAdapter.HadithViewHolder>() {
    var hadithItemClickListener: OnHadithItemClickListener? = null

    class HadithViewHolder(val binding: HadithItemBinding) : ViewHolder(binding.root) {
        fun bind(verse: String) {
            binding.text.text = verse
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HadithItemBinding.inflate(inflater, parent, false)
        return HadithViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hadithList?.size ?: 0
    }

    override fun onBindViewHolder(holder: HadithViewHolder, position: Int) {

        val item = hadithList?.get(position) ?: return
        holder.binding.root.setOnClickListener {
            hadithItemClickListener?.OnHadithClick(position)
        }
        holder.bind(item)
    }

    interface OnHadithItemClickListener {
        fun OnHadithClick(HadithItemPosition: Int)
    }

    fun updateData(verses: List<String>) {
        this.hadithList = verses
        notifyDataSetChanged()
    }

}