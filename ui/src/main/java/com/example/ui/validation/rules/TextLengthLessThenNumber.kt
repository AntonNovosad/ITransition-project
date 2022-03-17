package com.example.ui.validation.rules

class TextLengthLessThenNumber(
    private val minLength: Int
) : ValidationRule {
    override fun validate(text: String): Boolean {
        return text.length < minLength
    }
}