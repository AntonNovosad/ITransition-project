package com.example.itransition_project.ui.login.fragment.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class EmailIsCorrect

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class TextIsNotEmpty

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class TextLengthLessThenNumberAnnotation

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class TextLengthMoreThenNumberAnnotation
