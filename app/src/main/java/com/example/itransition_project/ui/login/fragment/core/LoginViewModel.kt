package com.example.itransition_project.ui.login.fragment.core

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.itransition_project.databinding.LoginFragmentBinding

class LoginViewModel : ViewModel() {

    init {
        Log.i("Login", "LoginViewModel created")
    }


    fun validationForm(email: String?, password: String?): Boolean {
        val isValidEmail = emptyValidator(email) && emailValidator(email)
        val isValidPassword = emptyValidator(password) && passwordValidator(password)
        return isValidEmail && isValidPassword
    }

    private fun emailValidator(email: String?): Boolean {
        return email != null && email.contains("@")
    }

    private fun passwordValidator(password: String?): Boolean {
        val minPasswordLength = 2
        val maxPasswordLength = 10
        if (password != null && password.length < minPasswordLength) {
            return false
        }
        if (password != null && password.length > maxPasswordLength) {
            return false
        }
        return true
    }

    private fun emptyValidator(text: String?): Boolean {
        return text != null && text.isNotEmpty()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("LoginCleaned", "LoginViewModel destroyed")
    }
}