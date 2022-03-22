package com.example.itransition_project.ui.main.home.fragment.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.usecase.HomeUseCase
import com.example.itransition_project.logger.Logger
import com.example.ui.home.model.Mapper
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val baseLogger: Logger,
    private val useCase: HomeUseCase,
    private val mapper: Mapper
) : ViewModelProvider.Factory {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(baseLogger, useCase, mapper) as T
    }
}