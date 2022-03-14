package com.example.itransition_project.ui.login.fragment.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ui.validation.Validator


class LoginViewModel(
    private val emailValidator: Validator,
    private val passwordValidator: Validator
) : ViewModel() {


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
        return emailValidator.validate(email) && passwordValidator.validate(password)
    }
}