package com.example.ui.validation.rules

class TextLengthLessThenNumber(
    private val minLenght: Int
) : ValidationRule {
    override fun validate(text: String): Boolean {
        return text.length < minLenght
    }
}