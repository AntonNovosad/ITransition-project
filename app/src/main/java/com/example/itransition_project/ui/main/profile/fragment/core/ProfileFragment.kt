package com.example.itransition_project.ui.main.profile.fragment.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.itransition_project.R
import com.example.itransition_project.databinding.ProfileFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ProfileFragment : DaggerFragment(R.layout.profile_fragment) {

    private lateinit var binding: ProfileFragmentBinding

    @Inject
    lateinit var profileViewModelFactory: ProfileViewModelFactory

    private val profileViewModel: ProfileViewModel by lazy {
        ViewModelProvider(this, profileViewModelFactory).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProfileFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        profileViewModel.text()
    }
}