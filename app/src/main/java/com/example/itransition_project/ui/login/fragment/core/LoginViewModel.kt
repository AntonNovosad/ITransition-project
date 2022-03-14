package com.example.itransition_project.ui.login.fragment.core

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.itransition_project.databinding.LoginFragmentBinding

private const val MIN_PASSWORD_LENGTH = 2
private const val MAX_PASSWORD_LENGTH = 10

class LoginViewModel : ViewModel() {

    fun validationForm(email: String, password: String): Boolean {
        val isValidEmail = emptyValidator(email) && emailValidator(email)
        val isValidPassword = emptyValidator(password) && passwordValidator(password)
        return isValidEmail && isValidPassword
    }

    private fun emailValidator(email: String): Boolean {
        return email.contains("@")
    }

    private fun passwordValidator(password: String): Boolean {
        if (password.length < MIN_PASSWORD_LENGTH) {
            return false
        }
        if (password.length > MAX_PASSWORD_LENGTH) {
            return false
        }
        return true
    }

    private fun emptyValidator(text: String): Boolean {
        return text.isNotEmpty()
    }
}