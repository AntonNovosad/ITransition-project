package com.example.itransition_project.ui.main.profile.fragment.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.itransition_project.R
import com.example.itransition_project.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment(R.layout.profile_fragment) {
    lateinit var binding: ProfileFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfileFragmentBinding.inflate(inflater)
        return binding.root
    }
}