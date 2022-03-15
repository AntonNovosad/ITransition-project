package com.example.ui.validation.rules

private const val MIN_TEXT_LENGTH = 2

class TextLengthMoreThenNumber : ValidationRule {
    override fun validate(text: String): Boolean {
        return text.length > MIN_TEXT_LENGTH
    }
}