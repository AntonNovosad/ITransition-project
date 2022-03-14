package com.example.ui.validation.rules

private const val MIN_PASSWORD_LENGTH = 2
private const val MAX_PASSWORD_LENGTH = 10

class PasswordIsCorrectValidationRule : ValidationRule {

    override fun validate(text: String): Boolean {
        if (text.length < MIN_PASSWORD_LENGTH) {
            return false
        }
        if (text.length > MAX_PASSWORD_LENGTH) {
            return false
        }
        return true
    }
}