package com.example.itransition_project.di

import com.example.itransition_project.ui.login.fragment.core.LoginViewModelFactory
import com.example.ui.validation.Validator
import com.example.ui.validation.rules.*
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ValidationModule {

    @Provides
    @Named("emailValidator")
    fun emailValidator(
        @Named("email") emailIsCorrect: ValidationRule,
        @Named("empty") textIsNotEmpty: ValidationRule
    ): Validator {
        return Validator(
            rules = listOf(emailIsCorrect, textIsNotEmpty)
        )
    }

    @Provides
    @Named("passwordValidator")
    fun passwordValidator(
        @Named("empty") textIsNotEmpty: ValidationRule,
        @Named("less") textLengthLessThenNumber: ValidationRule,
        @Named("more") textLengthMoreThenNumber: ValidationRule
    ): Validator {
        return Validator(
            rules = listOf(
                textIsNotEmpty,
                textLengthMoreThenNumber,
                textLengthLessThenNumber
            )
        )
    }

    @Provides
    @Named("email")
    fun provideEmailIsCorrect(): ValidationRule {
        return EmailIsCorrectValidationRule()
    }

    @Provides
    @Named("empty")
    fun provideTextIsNotEmpty(): ValidationRule {
        return TextIsNotEmptyValidationRule()
    }

    @Provides
    @Named("less")
    fun provideTextLengthLessThenNumber(): ValidationRule {
        // TODO Константу
        return TextLengthLessThenNumber(10)
    }

    @Provides
    @Named("more")
    fun provideTextLengthMoreThenNumber(): ValidationRule {
        return TextLengthMoreThenNumber()
    }
}