package com.example.ui.validation

import com.example.ui.validation.rules.ValidationRule

class Validator(private val rules: List<ValidationRule>) {

    fun validate(text: String): Boolean {

        var isValidated: Boolean = true

        rules.forEach { rule ->
            val isTextValid = rule.validate(text)
            if (!isTextValid) {
                isValidated = false
            }
        }

        return isValidated
    }
}