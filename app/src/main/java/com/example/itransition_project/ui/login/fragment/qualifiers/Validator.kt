package com.example.itransition_project.ui.login.fragment.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class EmailValidator

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PasswordValidator