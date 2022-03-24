package com.example.itransition_project.di

import com.example.itransition_project.di.core.LoggerModule
import com.example.itransition_project.di.core.RepositoryModule
import com.example.itransition_project.di.core.RetrofitModule
import com.example.itransition_project.ui.login.fragment.di.LoginActivityModule
import com.example.itransition_project.ui.main.di.MainActivityModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        LoginActivityModule::class,
        LoggerModule::class,
        MainActivityModule::class,
        RepositoryModule::class,
        RetrofitModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MyApp> {
    }
}