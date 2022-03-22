package com.example.itransition_project.ui.main.home.fragment.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.HomeUseCase
import com.example.itransition_project.logger.Logger
import com.example.ui.home.model.HomeDataUi
import com.example.ui.home.model.Mapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val baseLogger: Logger,
    private val useCase: HomeUseCase,
    private val mapper: Mapper
) : ViewModel() {


    private val homeDataMutableStateFlow = MutableStateFlow(emptyList<HomeDataUi>())
    val homeDataStateFlow: StateFlow<List<HomeDataUi>> = homeDataMutableStateFlow.asStateFlow()

    init {
        baseLogger.logInfo("HomeViewModel")
    }

    fun getListHomeData() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = useCase.getHomeDataEntity().collect { flowList ->
                val newList = mapper.map(flowList)
                homeDataMutableStateFlow.emit(newList)
            }
        }
    }
}