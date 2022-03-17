package com.example.itransition_project.logger

import android.util.Log

class BaseLogger : Logger {
    override fun logDebug(text: String) {
        Log.d("DEBUG", text)
    }

    override fun logError(text: String, exception: Throwable) {
        Log.e("ERROR", text, exception)
    }

    override fun logInfo(text: String) {
        Log.i("INFO", text)
    }
}