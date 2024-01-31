package com.example.islami.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.HadithDetailsActivity
import com.example.islami.adapters.HadithAdapter
import com.example.islami.databinding.FragmentHadithBinding

class HadithFragment : Fragment() {

    lateinit var adapter: HadithAdapter
    lateinit var binding: FragmentHadithBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHadithBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HadithAdapter(null)
        binding.hadithFragmentRecyclerView.adapter = adapter
        readHadithFile()

    }

    private fun readHadithFile() {
        val fileName = "ahadeeth.txt"

        //read file
        val suraContentAsString = requireContext().assets.open(fileName).bufferedReader().use {
            it.readText()
        }

        //split each hadith in the text file
        val hadithList = suraContentAsString.trim().split("#")
        //declare the title list
        val title = mutableListOf<String>()
        //declare the hadith content "description"
        val description = mutableListOf<String>()

        //for each hadith in the list
        //split the title and the content
        for (hadith in hadithList) {
            val mutableHadithList = hadith.trim().split("\n")
            //first separation is the title
            title.add(mutableHadithList[0])
            //all the content is the description and the title of the part
            description.add(mutableHadithList.joinToString("\n"))
        }

        adapter.hadithItemClickListener = object : HadithAdapter.OnHadithItemClickListener {
            override fun OnHadithClick(hadithItemPosition: Int) {
                val intent = Intent(requireContext(), HadithDetailsActivity::class.java)
                val item = description[hadithItemPosition]
                intent.putExtra("item", item)
                startActivity(intent)
            }
        }
        adapter.updateData(title.toList())


    }

}