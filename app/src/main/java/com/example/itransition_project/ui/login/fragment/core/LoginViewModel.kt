package com.example.itransition_project.ui.login.fragment.core

import androidx.lifecycle.ViewModel
import com.example.ui.validation.Validator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject
import javax.inject.Named


class LoginViewModel (
    @Named("emailValidator")
    private val emailValidator: Validator,
    @Named("passwordValidator")
    private val passwordValidator: Validator
) : ViewModel() {


    private val emailMutableStateFlow = MutableStateFlow("")
    val emailStateFlow: StateFlow<String> = emailMutableStateFlow.asStateFlow()

    private val passwordMutableStateFlow = MutableStateFlow("")
    val passwordStateFlow: StateFlow<String> = passwordMutableStateFlow.asStateFlow()

    val isFormValidStateFlow =
        emailMutableStateFlow.combine(passwordMutableStateFlow) { email, password ->
            validationForm(email, password)
        }


    fun updateEmailText(text: String) {
        emailMutableStateFlow.value = text
    }

    fun updatePasswordText(text: String) {
        passwordMutableStateFlow.value = text
    }

    private fun validationForm(email: String, password: String): Boolean {
        return emailValidator.validate(email) && passwordValidator.validate(password)
    }
}