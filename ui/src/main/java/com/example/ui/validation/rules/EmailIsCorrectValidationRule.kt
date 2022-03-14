package com.example.ui.validation.rules

class EmailIsCorrectValidationRule : ValidationRule {

    override fun validate(text: String): Boolean {
        return text.contains("@")
    }
}