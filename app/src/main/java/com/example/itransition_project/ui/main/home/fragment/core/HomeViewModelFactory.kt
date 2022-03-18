package com.example.itransition_project.ui.main.home.fragment.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itransition_project.logger.Logger
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val baseLogger: Logger
) : ViewModelProvider.Factory {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(baseLogger) as T
    }
}