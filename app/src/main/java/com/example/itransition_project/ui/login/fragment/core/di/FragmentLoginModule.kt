package com.example.itransition_project.ui.login.fragment.core.di

import com.example.itransition_project.di.ScopeFragment
import com.example.itransition_project.ui.login.fragment.core.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentLoginModule {
    @ScopeFragment
    @ContributesAndroidInjector(modules = [ValidationModule::class])
    abstract fun contributeLoginFragment(): LoginFragment
}