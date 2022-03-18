package com.example.itransition_project.ui.main.home.fragment.core

import androidx.lifecycle.ViewModel
import com.example.itransition_project.logger.Logger

class HomeViewModel (
    private val baseLogger: Logger
) : ViewModel() {

    init {
        baseLogger.logInfo("HomeViewModel")
    }

    fun text(){

    }

}