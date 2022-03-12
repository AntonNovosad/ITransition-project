package com.example.itransition_project.ui.home.fragment.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.itransition_project.databinding.HomeFragmentBinding
import com.example.itransition_project.databinding.LoginFragmentBinding

class HomeFragment : Fragment() {
    lateinit var binding: HomeFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater)
        return binding.root
    }
}