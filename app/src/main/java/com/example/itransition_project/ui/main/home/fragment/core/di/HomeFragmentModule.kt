package com.example.itransition_project.ui.main.home.fragment.core.di

import com.example.itransition_project.di.ScopeFragment
import com.example.itransition_project.ui.main.home.fragment.core.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class HomeFragmentModule {
    @ScopeFragment
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment
}