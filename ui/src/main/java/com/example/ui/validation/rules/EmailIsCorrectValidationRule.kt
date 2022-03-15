package com.example.ui.validation.rules

import android.util.Patterns

class EmailIsCorrectValidationRule : ValidationRule {

    override fun validate(text: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(text).matches()
    }
}