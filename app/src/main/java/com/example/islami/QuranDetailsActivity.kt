package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.adapters.VersesAdapter
import com.example.islami.databinding.ActivityQuranDetailsBinding

class QuranDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuranDetailsBinding
    lateinit var adapter: VersesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuranDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            finish()
        }
        val title = intent.getStringExtra("name")
        val index = intent.getIntExtra("index", -1)
        binding.title.text = title
        adapter = VersesAdapter(null)
        binding.quranRecyclerView.adapter = adapter
        readFromAssets(index)

    }

    private fun readFromAssets(index: Int) {
        val fileName = "$index.txt"
        val suraContentAsString = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        val verses = suraContentAsString.split("\n")
        adapter.updateData(verses)
    }
}