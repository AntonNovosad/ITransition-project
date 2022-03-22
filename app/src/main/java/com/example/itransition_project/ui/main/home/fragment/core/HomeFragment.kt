package com.example.itransition_project.ui.main.home.fragment.core

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itransition_project.R
import com.example.itransition_project.databinding.HomeFragmentBinding
import com.example.itransition_project.extensions.repeatWithLifecycle
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class HomeFragment : DaggerFragment(R.layout.home_fragment) {

    private lateinit var binding: HomeFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private val homeRecyclerAdapter: HomeRecyclerAdapter = HomeRecyclerAdapter()


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
        recyclerView = binding.homeRecyclerView
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = homeRecyclerAdapter

        repeatWithLifecycle {
            homeViewModel.homeDataStateFlow.collect { list ->
                homeRecyclerAdapter.updateData(list)
            }
        }

        homeViewModel.getListHomeData()
    }
}