package com.example.itransition_project.ui.login.fragment.core.di

import com.example.itransition_project.ui.login.fragment.qualifiers.*
import com.example.ui.validation.Validator
import com.example.ui.validation.rules.*
import dagger.Module
import dagger.Provides


private const val MIN_TEXT_LENGTH = 2
private const val MAX_TEXT_LENGTH = 10

@Module
class ValidationModule {

    @Provides
    @EmailValidator
    fun emailValidator(
        @EmailIsCorrect emailIsCorrect: ValidationRule,
        @TextIsNotEmpty textIsNotEmpty: ValidationRule
    ): Validator {
        return Validator(
            rules = listOf(emailIsCorrect, textIsNotEmpty)
        )
    }

    @Provides
    @PasswordValidator
    fun passwordValidator(
        @TextIsNotEmpty textIsNotEmpty: ValidationRule,
        @TextLengthLessThenNumberAnnotation textLengthLessThenNumber: ValidationRule,
        @TextLengthMoreThenNumberAnnotation textLengthMoreThenNumber: ValidationRule
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
    @EmailIsCorrect
    fun provideEmailIsCorrect(): ValidationRule {
        return EmailIsCorrectValidationRule()
    }

    @Provides
    @TextIsNotEmpty
    fun provideTextIsNotEmpty(): ValidationRule {
        return TextIsNotEmptyValidationRule()
    }

    @Provides
    @TextLengthLessThenNumberAnnotation
    fun provideTextLengthLessThenNumber(): ValidationRule {
        return TextLengthLessThenNumber(MAX_TEXT_LENGTH)
    }

    @Provides
    @TextLengthMoreThenNumberAnnotation
    fun provideTextLengthMoreThenNumber(): ValidationRule {
        return TextLengthMoreThenNumber(MIN_TEXT_LENGTH)
    }
}