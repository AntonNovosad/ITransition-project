package com.example.itransition_project.ui.login.fragment.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ui.validation.Validator
import javax.inject.Inject
import javax.inject.Named

class LoginViewModelFactory (
    @Named("emailValidator")
    val emailValidator: Validator,
    @Named("passwordValidator")
    val passwordValidator: Validator
) : ViewModelProvider.Factory {

//    private val emailValidator: Validator = Validator(
//        rules = listOf(EmailIsCorrectValidationRule(), TextIsNotEmptyValidationRule())
//    )
//    private val passwordValidator: Validator = Validator(
//        rules = listOf(
//            TextIsNotEmptyValidationRule(),
//            TextLengthMoreThenNumber(),
//            TextLengthLessThenNumber()
//        )
//    )


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(emailValidator, passwordValidator) as T
    }
}