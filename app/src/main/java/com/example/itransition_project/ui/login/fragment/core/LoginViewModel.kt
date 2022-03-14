package com.example.itransition_project.ui.login.fragment.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private const val MIN_PASSWORD_LENGTH = 2
private const val MAX_PASSWORD_LENGTH = 10

class LoginViewModel : ViewModel() {

    private val emailMutableLiveData = MutableLiveData<String>()
    val emailLiveData: LiveData<String> = emailMutableLiveData

    private val passwordMutableLiveData = MutableLiveData<String>()
    val passwordLiveData: LiveData<String> = passwordMutableLiveData

    val isFormValidLiveData: LiveData<Boolean> = MediatorLiveData<Boolean>().apply {
        value = false

        addSource(emailLiveData) { email ->
            val password = passwordMutableLiveData.value ?: ""
            this.value = validationForm(email, password)
        }
        addSource(passwordLiveData) { password ->
            val email = emailMutableLiveData.value ?: ""
            this.value = validationForm(email, password)
        }
    }

    fun updateEmailText(text: String) {
        emailMutableLiveData.value = text
    }

    fun updatePasswordText(text: String) {
        passwordMutableLiveData.value = text
    }

    private fun validationForm(email: String, password: String): Boolean {
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