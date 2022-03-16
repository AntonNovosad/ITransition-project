package com.example.itransition_project.ui.login.fragment.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ui.validation.Validator
import javax.inject.Inject
import javax.inject.Named

class LoginViewModelFactory @Inject constructor(
    @Named("emailValidator")
    private val emailValidator: Validator,
    @Named("passwordValidator")
    private val passwordValidator: Validator
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(emailValidator, passwordValidator) as T
    }
}