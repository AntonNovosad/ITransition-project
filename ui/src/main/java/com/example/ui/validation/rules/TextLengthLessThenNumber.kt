package com.example.ui.validation.rules

private const val MAX_TEXT_LENGTH = 10

class TextLengthLessThenNumber : ValidationRule {
    override fun validate(text: String): Boolean {
        return text.length < MAX_TEXT_LENGTH
    }
}