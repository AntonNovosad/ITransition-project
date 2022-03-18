package com.example.itransition_project.logger

import javax.inject.Inject

interface Logger {
    fun logDebug(text: String)
    fun logError(text: String, exception: Throwable)
    fun logInfo(text: String)

}