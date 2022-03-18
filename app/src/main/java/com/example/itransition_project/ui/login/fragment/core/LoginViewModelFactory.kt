package com.example.itransition_project.ui.login.fragment.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itransition_project.ui.login.fragment.qualifiers.EmailValidator
import com.example.itransition_project.ui.login.fragment.qualifiers.PasswordValidator
import com.example.ui.validation.Validator
import javax.inject.Inject

class LoginViewModelFactory @Inject constructor(
    @EmailValidator
    private val emailValidator: Validator,
    @PasswordValidator
    private val passwordValidator: Validator
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel( emailValidator, passwordValidator) as T
    }
}