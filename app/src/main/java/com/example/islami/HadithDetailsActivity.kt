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

        //get the content of the hadith from the hadith fragment
        val description = intent.getStringExtra("item")
        // split the lines
        val descriptionList = description?.split("\n")?.toMutableList()
        //the first line is the title
        val title = descriptionList?.get(0)
        //remove the first line which is the title
        descriptionList?.removeAt(0)
        //the rest for the hadith description
        adapter = HadithAdapter(descriptionList)
        binding.hadithRecyclerView.adapter = adapter
        binding.title.text = title
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}