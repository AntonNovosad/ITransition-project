package com.example.ui.validation.rules

class TextIsNotEmptyValidationRule : ValidationRule {

    override fun validate(text: String): Boolean {
        return text.isNotEmpty()
    }
}