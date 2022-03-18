package com.example.itransition_project.ui.main.profile.fragment.core.di

import com.example.itransition_project.di.ScopeFragment
import com.example.itransition_project.ui.main.profile.fragment.core.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileFragmentModule {
    @ScopeFragment
    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment
}