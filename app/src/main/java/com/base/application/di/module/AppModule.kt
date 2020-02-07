package com.base.application.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
internal class AppModule constructor(private val application: Application) {

    @Provides
    fun providesContext(): Context = application
}