package com.example.itransition_project.di

import com.example.itransition_project.ui.login.LoginActivity
import com.example.itransition_project.ui.login.fragment.core.LoginFragment
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ValidationModule::class, AppComponent.ActivityBindingModule::class])
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MyApp> {
    }

    @Module
    abstract class ActivityBindingModule {
        @ScopeActivity
        @ContributesAndroidInjector(modules = [ActivityLoginModule::class, FragmentLoginModule::class])
        abstract fun contributeLoginActivity(): LoginActivity
    }

    @Module
    abstract class ActivityLoginModule {
        @ScopeFragment
        @ContributesAndroidInjector
        abstract fun contributeLoginFragment(): LoginActivity
    }

    @Module
    abstract class FragmentLoginModule {
        @ScopeFragment
        @ContributesAndroidInjector
        abstract fun contributeLoginFragment(): LoginFragment
    }
}