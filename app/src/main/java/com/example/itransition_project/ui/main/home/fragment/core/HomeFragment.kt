package com.example.itransition_project.ui.main.home.fragment.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.itransition_project.R
import com.example.itransition_project.databinding.HomeFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class HomeFragment : DaggerFragment(R.layout.home_fragment) {

    lateinit var binding: HomeFragmentBinding

    @Inject
    lateinit var homeViewModelFactory: HomeViewModelFactory

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, homeViewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.text()
    }
}