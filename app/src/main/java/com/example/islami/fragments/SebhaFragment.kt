package com.example.islami.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {

    private lateinit var binding: FragmentSebhaBinding
    private lateinit var Tasbeh: List<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tasbehCounter = 1
        var tasbehListCounter = 0
        var rotationAngle = 5f
        Tasbeh = listOf("الله اكبر", "الحمدلله", "سبحان الله")
        binding.counter.text = "$tasbehCounter"

        binding.tasbeh.setOnClickListener {
            if (tasbehCounter in 1..32) {
                binding.counter.text = "${tasbehCounter++}"

            } else if (tasbehCounter == 33) {
                tasbehCounter = 1
                binding.counter.text = "$tasbehCounter"
                if (tasbehListCounter == 3) {
                    tasbehListCounter = 0
                    binding.tasbeh.text = Tasbeh[tasbehListCounter]
                }
                binding.tasbeh.text = Tasbeh[tasbehListCounter++]
            }
            rotationAngle += (360 / 33).toFloat()
            binding.body.rotation = rotationAngle
        }

    }
}
