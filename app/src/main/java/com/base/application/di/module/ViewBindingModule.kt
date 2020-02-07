package com.base.application.di.module

import com.base.application.presentation.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ViewBindingModule {

    @ContributesAndroidInjector
    abstract fun providesMainActivity() : MainActivity
}