package com.example.islami.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.QuranDetailsActivity
import com.example.islami.adapters.QuranAdapter
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.model.SuraNameIndex
import com.example.islami.model.arSuras

class QuranFragment : Fragment() {

    lateinit var binding: FragmentQuranBinding
    lateinit var adapter: QuranAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuranBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val suras = arSuras.mapIndexed { position, name ->
            SuraNameIndex(name, position + 1)
        }
        adapter = QuranAdapter(suras)
        adapter.QuranClickListener = object : QuranAdapter.OnQuranClickListener {
            override fun onQuranClick(suraNameIndex: SuraNameIndex, position: Int) {
                val intent = Intent(requireContext(), QuranDetailsActivity::class.java)
                intent.putExtra("name", suraNameIndex.name)
                intent.putExtra("index", suraNameIndex.index)
                startActivity(intent)
            }
        }
        binding.quranFragmentRecyclerView.adapter = adapter
    }
}