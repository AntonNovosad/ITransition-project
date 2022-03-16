package com.example.ui.validation

import com.example.ui.validation.rules.ValidationRule
import javax.inject.Inject

class Validator @Inject constructor(private val rules: List<ValidationRule>) {

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