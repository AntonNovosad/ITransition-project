package com.example.itransition_project.di

import com.example.itransition_project.ui.login.LoginActivity
import com.example.itransition_project.ui.login.fragment.core.LoginFragment
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppComponent.ActivityBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MyApp> {
    }

    @Module(
        includes = [
            LoginActivityModule::class,
        ]
    )
    abstract class ActivityBindingModule

    @Module
    abstract class FragmentLoginModule {
        @ScopeFragment
        @ContributesAndroidInjector(modules = [ValidationModule::class])
        abstract fun contributeLoginFragment(): LoginFragment
    }
}

@Module
abstract class LoginActivityModule {
    @ScopeActivity
    @ContributesAndroidInjector(
        modules = [AppComponent.FragmentLoginModule::class]
    )
    abstract fun contributeLoginActivity(): LoginActivity
}