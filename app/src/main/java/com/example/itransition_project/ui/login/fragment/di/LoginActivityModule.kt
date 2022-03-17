package com.example.itransition_project.ui.login.fragment.di

import com.example.itransition_project.di.ScopeActivity
import com.example.itransition_project.ui.login.LoginActivity
import com.example.itransition_project.ui.login.fragment.core.di.FragmentLoginModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginActivityModule {
    @ScopeActivity
    @ContributesAndroidInjector(modules = [FragmentLoginModule::class])
    abstract fun contributeLoginActivity(): LoginActivity
}