package com.example.itransition_project.ui.main.di

import com.example.itransition_project.di.ScopeActivity
import com.example.itransition_project.ui.main.MainActivity
import com.example.itransition_project.ui.main.home.fragment.core.di.HomeFragmentModule
import com.example.itransition_project.ui.main.profile.fragment.core.di.ProfileFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ScopeActivity
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class, ProfileFragmentModule::class])
    abstract fun contributeMainActivity(): MainActivity
}