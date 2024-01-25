package com.example.islami

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.databinding.ActivityMainBinding
import com.example.islami.fragments.HadeethFragment
import com.example.islami.fragments.QuranFragment
import com.example.islami.fragments.RadioFragment
import com.example.islami.fragments.SebhaFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.sebha -> {
                    pushFragment(SebhaFragment())
                }

                R.id.quran -> {
                    pushFragment(QuranFragment())
                }

                R.id.radio -> {
                    pushFragment(RadioFragment())
                }

                R.id.hadeeth -> {
                    pushFragment(HadeethFragment())
                }

            }
            return@setOnItemSelectedListener true
        }
        binding.bottomNavigationView.selectedItemId = R.id.quran


    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.mainFragment.id, fragment)
            .commit()
    }
}