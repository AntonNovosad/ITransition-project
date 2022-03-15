package com.example.ui.validation.rules

interface ValidationRule {
    fun validate(text: String): Boolean
}