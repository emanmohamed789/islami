package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islami.adapters.HadithAdapter
import com.example.islami.databinding.ActivityHadithDetailsBinding

class HadithDetailsActivity : AppCompatActivity() {
    lateinit var adapter: HadithAdapter
    lateinit var binding: ActivityHadithDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadithDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val description = intent.getStringExtra("item")
        val descriptionList = description?.split("\n")?.toMutableList()
        val title = descriptionList?.get(0)
        descriptionList?.removeAt(0)
        adapter = HadithAdapter(descriptionList)
        binding.hadithRecyclerView.adapter = adapter
        binding.title.text = title
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}