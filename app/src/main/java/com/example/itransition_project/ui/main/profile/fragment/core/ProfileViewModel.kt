package com.example.itransition_project.ui.main.profile.fragment.core

import androidx.lifecycle.ViewModel
import com.example.itransition_project.logger.Logger

class ProfileViewModel(
    private val baseLogger: Logger
) : ViewModel() {


    init {
        baseLogger.logInfo("ProfileViewModel")
    }

    fun text(){

    }
}